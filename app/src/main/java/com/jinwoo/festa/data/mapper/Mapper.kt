package com.jinwoo.festa.data.mapper

interface Mapper<in T, E>{
    fun mapFrom(from: T): E
}