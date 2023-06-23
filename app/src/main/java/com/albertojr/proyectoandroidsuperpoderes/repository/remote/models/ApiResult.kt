package com.albertojr.proyectoandroidsuperpoderes.repository.remote.models

data class ApiResult<T> (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data<T>
)

data class Data<T> (
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<T>
)


data class Thumbnail (
    val path: String,
    val extension: Extension
)

enum class Extension {
    jpg
}