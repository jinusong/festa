package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.entity.PageData
import io.reactivex.Flowable

interface EventDataSource {
    fun getRemoteEventList(pageSize: Int): Flowable<PageData>

    fun saveDbEventList(event: Event)

    fun getDbEventList(): List<Event>
}