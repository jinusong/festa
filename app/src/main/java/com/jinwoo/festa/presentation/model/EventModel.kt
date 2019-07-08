package com.jinwoo.festa.presentation.model

data class EventModel(
    val eventId: Int,
    val eventName: String,
    val eventDate: String,
    val ticketPriceRange: String,
    val locationName: String,
    val eventImageUrl: String,
    val hostName: String,
    var state: Boolean
)