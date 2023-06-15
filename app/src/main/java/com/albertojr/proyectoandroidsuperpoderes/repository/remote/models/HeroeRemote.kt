package com.albertojr.proyectoandroidsuperpoderes.repository.remote.models

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Thumbnail


data class HeroeRemote (
    val id: Long,
    val name: String,
    val description: String,
//    val modified: String,
    val thumbnail: Thumbnail,
)