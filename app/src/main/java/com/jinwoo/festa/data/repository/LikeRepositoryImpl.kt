package com.jinwoo.festa.data.repository

import com.jinwoo.festa.data.datasource.LikeDataSource
import com.jinwoo.festa.data.mapper.LikeDataMapper
import com.jinwoo.festa.domain.entity.LikeEntity
import com.jinwoo.festa.domain.entity.LikeRepository
import io.reactivex.Flowable

class LikeRepositoryImpl(val datasource: LikeDataSource, val likeDataMapper: LikeDataMapper): LikeRepository {

    override fun getLike(eventId: Int): LikeEntity?
            = likeDataMapper.mapFrom(datasource.getLike(eventId))

    override fun saveLike(like: LikeEntity)
            = datasource.saveLike(likeDataMapper.mapEntityToDb(like))
}