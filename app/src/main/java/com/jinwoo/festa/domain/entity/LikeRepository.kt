package com.jinwoo.festa.domain.entity

interface LikeRepository {
    fun getLike(eventId: Int): LikeEntity?

    fun saveLike(like: LikeEntity)
}