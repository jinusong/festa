package com.jinwoo.festa.data.repository

import com.jinwoo.festa.data.datasource.EventDataSource
import com.jinwoo.festa.data.mapper.EventDataMapper
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.EventRepository
import io.reactivex.Flowable

class EventRepositoryImpl(val datasource: EventDataSource, val eventDataMapper: EventDataMapper): EventRepository {

    override fun getEventList(pageSize: Int): Flowable<ArrayList<EventEntity>>
            = datasource.getRemoteEventList(pageSize).map {
        ArrayList(it.rows.map { eventDataMapper.mapFrom(it) })}

    override fun getLocalEventList(): ArrayList<EventEntity>
            = ArrayList(datasource.getDbEventList().map { eventDataMapper.mapDbToEntity(it) })

    override fun saveLocalEventList(eventList: ArrayList<EventEntity>)
            = eventList.forEach { datasource.saveDbEventList(eventDataMapper.mapEntityToDb(it)) }
}