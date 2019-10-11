package com.jinwoo.festa.data.mapper

import com.jinwoo.festa.data.database.entity.Like
import com.jinwoo.festa.domain.entity.LikeEntity
import com.jinwoo.festa.domain.mapper.Mapper

class LikeDataMapper: Mapper<Like?, LikeEntity?> {
    override fun mapFrom(from: Like?): LikeEntity? {
        from?.let {
            return LikeEntity(
                eventId = from.eventId,
                isLike = from.isLike
            )
        }

        return null
    }

    fun mapEntityToDb(from: LikeEntity): Like
        = Like(
        eventId = from.eventId,
        isLike = from.isLike
    )
}