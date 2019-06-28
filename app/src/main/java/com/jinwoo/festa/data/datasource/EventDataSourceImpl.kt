package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.Api
import com.jinwoo.festa.data.database.dao.EventDao
import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.entity.EventData
import io.reactivex.Flowable


class EventDataSourceImpl(val api: Api, val eventDao: EventDao): EventDataSource {
    override fun getRemoteEventList(pageSize: Int): Flowable<List<EventData>>
            = api.getEventList(pageSize = pageSize).map { it.rows }

    override fun saveDbEventList(event: Event)
            = eventDao.saveEventList(event)

    override fun getDbEventList(): List<Event>
            = eventDao.getEventList()
}