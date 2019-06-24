package com.jinwoo.festa.data

class ApiClient(val api: Api) {
    fun getEventList(page: Int, pageSize: Int, order: String = "startDate")
            = getEventList(page, pageSize, order)
}