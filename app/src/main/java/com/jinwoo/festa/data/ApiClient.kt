package com.jinwoo.festa.data

import com.jinwoo.festa.data.entity.PageData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiClient(val api: Api) {
    fun getEventList(page: Int, pageSize: Int, order: String = "startDate"): Flowable<PageData>
            = getEventList(page, pageSize, order)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}