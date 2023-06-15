package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Date
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Format
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Price
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Thumbnail

data class Comic(
    val id: Long,
    val title: String,
    val issueNumber: Long,
//    val thumbnail: Thumbnail,
    val picture:String,
    val images: List<Thumbnail>,
)

