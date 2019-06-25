package com.jinwoo.festa.domain.entity

data class EventEntity(
    val eventName: Int,
    val startDate: String,
    val ticketPriceRange: String,
    val locationName: String,
    val eventImageUrl: String,
    val hostName: String
)