package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.ComicRemote
import javax.inject.Inject

class ComicResultToComic @Inject constructor() {
    fun mapComicResultToComics(comicResultList: List<ComicRemote>): List<Comic> {
        return comicResultList.map { mapComicResultToComic(it) }
    }

    private fun mapComicResultToComic(comicResult: ComicRemote): Comic {
        return Comic(
            comicResult.id,
            comicResult.title,
            comicResult.issueNumber,
            comicResult.thumbnail,
            comicResult.images
        )
    }
}