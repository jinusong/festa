package com.jinwoo.festa.domain.entity

data class EventEntity(
    val eventId: Int,
    val eventName: String,
    var eventDate: String,
    val tickets: ArrayList<TicketEntity>,
    val locationName: String,
    val eventImageUrl: String,
    val hostName: String,
    var ticketPriceRange: String,
    var state: Boolean
)