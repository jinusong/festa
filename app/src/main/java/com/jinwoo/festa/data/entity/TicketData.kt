package com.jinwoo.festa.data.entity

import com.google.gson.annotations.SerializedName

data class TicketData(
    @SerializedName("price")
    val price: Int)