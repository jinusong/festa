package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.Api
import com.jinwoo.festa.data.entity.PageData
import io.reactivex.Flowable


class EventDataSourceImpl(val api: Api): EventDataSource {
    override fun getRemoteEventList(pageSize: Int): Flowable<PageData>
            = api.getEventList(pageSize = pageSize)
}