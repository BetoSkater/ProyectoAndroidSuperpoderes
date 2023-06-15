package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.local.models.HeroeLocal
import javax.inject.Inject

class HeroesToHeroeLocal @Inject constructor() {

    fun  mapHeroesToHeroesLocal(heroeList: List<Heroe>): List<HeroeLocal>{
        return heroeList.map{mapHeroeToHeroeLocal(it)}
    }

    //This one is public to in order to reuse it the while retrieven a single heroe from the localDataBase
     fun mapHeroeToHeroeLocal(heroe: Heroe): HeroeLocal {
        return HeroeLocal(
            heroe.id,
            heroe.name,
            heroe.description,
//            heroe.modified,
            heroe.picture
        )
    }

}