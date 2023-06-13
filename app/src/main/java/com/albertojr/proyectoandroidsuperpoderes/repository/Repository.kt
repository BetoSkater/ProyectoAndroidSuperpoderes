package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteHeroe

interface Repository {
    suspend fun retrieveHeroes(): List<Heroe>
    suspend fun retrieveHeroeComics(heroeId: Long): List<Comic>
    suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie>
}