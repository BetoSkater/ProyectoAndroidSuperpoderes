package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Thumbnail

data class Heroe (
    val id: Long,
    val name: String,
    val description: String,
//    val modified: String,
//    val thumbnail: Thumbnail,
    val picture : String,
    var isFavourite: Boolean = false
)

