package com.albertojr.proyectoandroidsuperpoderes.repository

data class Heroe (
    val id: Long,
    val name: String,
    val description: String,
    val picture : String,
    var isFavourite: Boolean = false
)

