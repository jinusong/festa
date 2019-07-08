package com.jinwoo.festa.data.repository

import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.datasource.EventDataSource
import com.jinwoo.festa.data.entity.EventData
import com.jinwoo.festa.data.mapper.EventDataMapper
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.EventRepository
import io.reactivex.Flowable

class EventRepositoryImpl(val datasource: EventDataSource, val eventDataMapper: EventDataMapper): EventRepository {

    private val mapDataListToEntityList: (List<EventData>) -> List<EventEntity>
            = { it.map { eventDataMapper.mapFrom(it) } }

    private val mapDbToEntity: (Event) -> EventEntity
            = { eventDataMapper.mapDbToEntity(it) }

    private val mapEntityToDb: (EventEntity) -> Event = { eventDataMapper.mapEntityToDb(it) }

    override fun getEventList(pageSize: Int): Flowable<List<EventEntity>>
            = datasource.getRemoteEventList(pageSize).map { mapDataListToEntityList(it) }

    override fun getLocalEventList(): List<EventEntity>
            = datasource.getDbEventList().map { mapDbToEntity(it) }

    override fun saveLocalEventList(eventList: List<EventEntity>)
            = eventList.forEach { datasource.saveDbEventList( mapEntityToDb(it) ) }
}