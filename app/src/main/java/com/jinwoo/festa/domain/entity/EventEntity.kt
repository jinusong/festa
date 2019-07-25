package com.jinwoo.festa.domain.entity

data class EventEntity(
    val eventId: Int,
    val eventName: String,
    val startDate: String,
    val endDate: String,
    var tickets: List<TicketEntity>,
    val locationName: String,
    val eventImageUrl: String,
    val eventContents: String,
    val hostName: String,
    val ticketPriceRange: String,
    var like: LikeEntity
)