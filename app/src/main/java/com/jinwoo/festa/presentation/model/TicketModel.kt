package com.jinwoo.festa.presentation.model

data class TicketModel(
    val ticketId: Int,
    val eventId: Int,
    val name: String,
    val count: Int,
    val quantity: Int,
    val limitPerUser: Int,
    val price: Int
)