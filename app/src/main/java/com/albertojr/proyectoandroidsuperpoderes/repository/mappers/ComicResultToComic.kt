package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.ComicsResult
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteHeroe
import javax.inject.Inject

class ComicResultToComic @Inject constructor() {
    fun mapComicResultToComics(comicResultList: List<ComicsResult>): List<Comic> {
        return comicResultList.map { mapComicResultToComic(it) }
    }

    fun mapComicResultToComic(comicResult: ComicsResult): Comic {
        return Comic(
            comicResult.id,
            comicResult.title,
            comicResult.issueNumber,
            comicResult.thumbnail,
            comicResult.images
        )
    }
}