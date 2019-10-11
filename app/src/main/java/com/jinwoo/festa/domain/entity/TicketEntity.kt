package com.jinwoo.festa.domain.entity

data class TicketEntity(
    val ticketId: Int,
    val eventId: Int,
    val name: String,
    val count: Int,
    val quantity: Int,
    val description: String,
    val limitPerUser: Int,
    val price: Int
)