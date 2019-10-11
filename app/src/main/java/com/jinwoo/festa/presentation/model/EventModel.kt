package com.jinwoo.festa.presentation.model

data class EventModel(
    val eventId: Int,
    val eventName: String,
    val startDate: String,
    val endDate: String,
    val locationName: String,
    val eventImageUrl: String,
    val eventContents: String,
    val hostName: String,
    val tickets: List<TicketModel> = ArrayList(),
    val ticketPriceRange: String,
    val like: LikeModel = LikeModel(eventId, false)
)