package com.jinwoo.festa.data.mapper

import com.jinwoo.festa.data.entity.HostData
import com.jinwoo.festa.domain.entity.HostEntity
import com.jinwoo.festa.domain.mapper.Mapper

class HostDataMapper: Mapper<HostData, HostEntity> {
    override fun mapFrom(from: HostData): HostEntity
            = HostEntity(from.name)
}