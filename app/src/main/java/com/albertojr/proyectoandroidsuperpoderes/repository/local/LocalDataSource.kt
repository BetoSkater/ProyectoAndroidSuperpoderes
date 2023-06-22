package com.albertojr.proyectoandroidsuperpoderes.repository.local

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.local.models.HeroeLocal

interface LocalDataSource {

    suspend fun getHeroes(): List<Heroe>

    suspend fun insertHeroes(heroes: List<Heroe>)

    suspend fun getHeroe(id: Long): Heroe

    suspend fun updateHeroeFavStateLocal(id: Long, isFav: Boolean) //TODO I think i can remove is fav and add it to the query in the DAO as x = !x

}