package com.albertojr.proyectoandroidsuperpoderes.repository.remote

data class HeroeSeriesApiResult (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: SeriesData
)

data class SeriesData (
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<SeriesResult>
)

data class SeriesResult (
    val id: Long,
    val title: String,
    val description: String? = null,
    val resourceURI: String,
    val startYear: Long,
    val endYear: Long,
    val rating: String,
    val type: String,
    val modified: String,
    val thumbnail: Thumbnail,
)