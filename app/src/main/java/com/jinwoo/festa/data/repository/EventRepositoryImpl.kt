package com.jinwoo.festa.data.repository

import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.datasource.EventDataSource
import com.jinwoo.festa.data.entity.EventData
import com.jinwoo.festa.data.mapper.EventDataMapper
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.EventListEntity
import com.jinwoo.festa.domain.entity.EventRepository
import io.reactivex.Flowable

class EventRepositoryImpl(val datasource: EventDataSource, val eventDataMapper: EventDataMapper): EventRepository {

    private val mapDataListToEntityList: (List<EventData>) -> List<EventEntity>
            = { it.map { eventDataMapper.mapFrom(it) } }

    private val mapDbToEntity: (Event) -> EventEntity
            = { eventDataMapper.mapDbToEntity(it) }

    private val mapEntityToDb: (EventEntity) -> Event = { eventDataMapper.mapEntityToDb(it) }

    override fun getEventList(pageSize: Int): Flowable<EventListEntity>
            = datasource.getRemoteEventList(pageSize).map { EventListEntity(true, mapDataListToEntityList(it)) }

    override fun getLocalEventList(): EventListEntity
            = EventListEntity(false,datasource.getDbEventList().map { mapDbToEntity(it) })

    override fun saveLocalEventList(eventList: EventListEntity)
            = datasource.saveDbEventList(eventList.eventEntity.map { mapEntityToDb(it) })
}