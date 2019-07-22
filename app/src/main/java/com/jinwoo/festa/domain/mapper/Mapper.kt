package com.jinwoo.festa.domain.mapper

interface Mapper<in T, E>{
    fun mapFrom(from: T): E
}