package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.database.dao.LikeDao
import com.jinwoo.festa.data.database.entity.Like

class LikeDataSourceImpl(val dao: LikeDao): LikeDataSource {
    override fun getLike(eventId: Int): Like
        = dao.getLike(eventId)

    override fun saveLike(like: Like)
        = dao.saveLike(like)
}