package com.albertojr.proyectoandroidsuperpoderes.repository.remote


data class Thumbnail (
    val path: String,
    val extension: Extension
)

enum class Extension {
    jpg
}