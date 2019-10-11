package com.jinwoo.festa.data.entity

import com.google.gson.annotations.SerializedName

data class MetadataData(
    @SerializedName("coverImage")
    val coverImage: String,
    @SerializedName("contents")
    val contents: String)