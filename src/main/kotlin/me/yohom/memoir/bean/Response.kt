package me.yohom.memoir.bean

data class Response<T>(
        val error: Boolean = false,
        val message: String = "请求成功",
        val results: List<T> = listOf()
)