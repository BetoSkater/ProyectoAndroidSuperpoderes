package com.albertojr.proyectoandroidsuperpoderes.repository.remote.models

data class SerieRemote (
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