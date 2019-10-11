package com.jinwoo.festa.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Like(
    @PrimaryKey
    val eventId: Int,
    val isLike: Boolean
)