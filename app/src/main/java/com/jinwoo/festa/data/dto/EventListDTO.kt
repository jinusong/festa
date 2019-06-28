package com.jinwoo.festa.data.dto

import com.google.gson.annotations.SerializedName
import com.jinwoo.festa.data.entity.EventData

data class EventListDTO (

    @SerializedName("rows")
    val rows: List<EventData>)