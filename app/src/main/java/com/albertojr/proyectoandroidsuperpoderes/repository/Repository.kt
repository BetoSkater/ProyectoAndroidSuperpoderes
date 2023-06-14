package com.albertojr.proyectoandroidsuperpoderes.repository

interface Repository {
    suspend fun retrieveHeroes(): List<Heroe>
    suspend fun retrieveHeroeComics(heroeId: Long): List<Comic>
    suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie>
}