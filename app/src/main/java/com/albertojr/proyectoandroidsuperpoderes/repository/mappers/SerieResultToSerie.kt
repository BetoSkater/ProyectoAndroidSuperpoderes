package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.SerieRemote
import javax.inject.Inject

class SerieResultToSerie @Inject constructor() {
    fun mapSerieResultToSeries(seriesResultList: List<SerieRemote>): List<Serie> {
        return seriesResultList.map { mapSerieResultToSerie(it) }
    }

    private fun mapSerieResultToSerie(serieResult: SerieRemote): Serie {
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