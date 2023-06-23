package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.Thumbnail

data class Comic(
    val id: Long,
    val title: String,
    val issueNumber: Long,
    val picture:String,
    val images: List<Thumbnail>,
)

