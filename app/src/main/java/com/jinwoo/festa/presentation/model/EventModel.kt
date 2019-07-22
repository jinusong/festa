package com.jinwoo.festa.presentation.model

data class EventModel(
    val eventId: Int,
    val eventName: String,
    var eventDate: String,
    val locationName: String,
    val eventImageUrl: String,
    val hostName: String,
    val ticketPriceRange: String
)