package com.jinwoo.festa.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ticket(
    @PrimaryKey
    val ticketId: Int,
    val eventId: Int,
    val name: String,
    val count: Int,
    val quantity: Int,
    val limitPerUser: Int,
    val price: Int
)