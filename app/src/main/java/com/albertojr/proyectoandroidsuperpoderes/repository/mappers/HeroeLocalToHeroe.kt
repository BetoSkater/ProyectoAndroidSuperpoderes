package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.local.models.HeroeLocal
import javax.inject.Inject

class HeroeLocalToHeroe @Inject constructor(){

    fun mapHeroesLocalToHeroes(heroeLocalList: List<HeroeLocal>): List<Heroe>{
        return heroeLocalList.map{mapHeroeLocalToHeroe(it)}
    }
    //Public for the detail view
    fun mapHeroeLocalToHeroe(heroeLocal: HeroeLocal): Heroe {
        return Heroe(
            heroeLocal.id,
            heroeLocal.name,
            heroeLocal.description,
            heroeLocal.photo,
            heroeLocal.isFavourite
        )
    }
}