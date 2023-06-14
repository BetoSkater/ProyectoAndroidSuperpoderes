package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.HeroeRemote

interface RemoteDataSource {

    suspend fun retrieveHeroes(): List<Heroe>
    suspend fun retrieveHeroeComics(heroeId: Long): List<Comic>
    suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie>

}