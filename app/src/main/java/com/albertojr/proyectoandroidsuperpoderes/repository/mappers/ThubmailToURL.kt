package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.Thumbnail

class ThubmailToURL {
    fun generateImageURLFromThumnail(thumbnail: Thumbnail):String{
        return "${thumbnail.path}/portrait_uncanny.${thumbnail.extension}"
    }
}