package com.jinwoo.festa.data.entity

import com.google.gson.annotations.SerializedName

data class PageData(
    @SerializedName("rows")
    val rows: List<EventData>)