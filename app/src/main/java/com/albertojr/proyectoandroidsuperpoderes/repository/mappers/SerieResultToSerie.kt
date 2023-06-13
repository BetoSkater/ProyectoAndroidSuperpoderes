package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteHeroe
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.SeriesResult
import javax.inject.Inject

class SerieResultToSerie @Inject constructor() {
    fun mapSerieResultToSeries(seriesResultList: List<SeriesResult>): List<Serie> {
        return seriesResultList.map { mapSerieResultToSErie(it) }
    }

    fun mapSerieResultToSErie(serieResult: SeriesResult): Serie {
        return Serie(
            serieResult.id,
            serieResult.title,
            serieResult.startYear,
            serieResult.endYear,
            serieResult.rating,
            serieResult.type,
            serieResult.thumbnail
        )
    }
}