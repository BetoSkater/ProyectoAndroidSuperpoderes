package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData

interface Repository {
    suspend fun retrieveHeroes(): List<Heroe>
    suspend fun retrieveHeroeById(id: Long): Heroe
    suspend fun retrieveHeroeComics(heroeId: Long): List<ItemCardData>
    suspend fun retrieveHeroeSeries(heroeId: Long): List<ItemCardData>
    suspend fun updateHeroeFavStateLocal(id: Long, isFav: Boolean)
}