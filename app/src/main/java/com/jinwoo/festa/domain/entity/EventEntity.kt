package com.jinwoo.festa.domain.entity

data class EventEntity(
    val eventId: Int,
    val eventName: String,
    val eventDate: String,
    val ticketPriceRange: String,
    val locationName: String,
    val eventImageUrl: String,
    val hostName: String
)