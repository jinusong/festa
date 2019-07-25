package com.jinwoo.festa.data.entity

import com.google.gson.annotations.SerializedName

data class TicketData(
    @SerializedName("ticketId")
    val ticketId: Int,
    @SerializedName("eventId")
    val eventId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("limitPerUser")
    val limitPerUser: Int,
    @SerializedName("price")
    val price: Int)