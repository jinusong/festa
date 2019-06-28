package com.jinwoo.festa.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jinwoo.festa.data.entity.HostData
import com.jinwoo.festa.data.entity.LocationData
import com.jinwoo.festa.data.entity.MetadataData
import com.jinwoo.festa.data.entity.TicketData

@Entity
data class Event(
    val eventId: Int,
    val eventName: String,
    var eventDate: String,
    val locationName: String,
    val eventImageUrl: String,
    val hostName: String,
    var ticketPriceRange: String
)