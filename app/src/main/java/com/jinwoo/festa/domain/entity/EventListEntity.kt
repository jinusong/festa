package com.jinwoo.festa.domain.entity

data class EventListEntity(
    val isRemote: Boolean,
    val eventEntity: List<EventEntity>
)