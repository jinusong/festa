package com.jinwoo.festa.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event(
    @PrimaryKey
    val eventId: Int,
    val eventName: String,
    var eventDate: String,
    val locationName: String,
    val eventImageUrl: String,
    val hostName: String,
    var ticketPriceRange: String
)