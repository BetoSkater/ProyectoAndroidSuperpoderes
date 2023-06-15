package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Thumbnail

data class Serie (
    val id: Long,
    val title: String,
    val startYear: Long,
    val endYear: Long,
    val rating: String,
    val type: String,
//    val thumbnail: Thumbnail,
val picture: String
)