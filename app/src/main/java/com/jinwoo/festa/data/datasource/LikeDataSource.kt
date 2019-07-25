package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.database.entity.Like

interface LikeDataSource {
    fun getLike(eventId: Int): Like
    fun saveLike(like: Like)
}