package com.jinwoo.festa.data

import com.jinwoo.festa.data.entity.PageData
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("events")
    fun getEventList(@Query("page") page: Int
                     , @Query("pageSize") pageSize: Int,
                     @Query("order") order: String): Flowable<PageData>
}