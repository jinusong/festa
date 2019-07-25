package com.jinwoo.festa.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event(
    @PrimaryKey
    val eventId: Int,
    val eventName: String,
    val startDate: String,
    val endDate: String,
    val locationName: String,
    val eventImageUrl: String,
    val eventContents: String,
    val hostName: String,
    val ticketPriceRange: String
)