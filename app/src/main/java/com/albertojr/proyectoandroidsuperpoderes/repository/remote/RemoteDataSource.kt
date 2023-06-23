package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie

interface RemoteDataSource {
    suspend fun retrieveHeroes(): List<Heroe>
    suspend fun retrieveHeroeComics(heroeId: Long): List<Comic>
    suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie>
}