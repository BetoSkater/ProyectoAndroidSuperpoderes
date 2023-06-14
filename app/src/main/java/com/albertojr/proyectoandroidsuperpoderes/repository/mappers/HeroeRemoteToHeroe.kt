package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.HeroeRemote
import javax.inject.Inject

class HeroeRemoteToHeroe @Inject constructor() {

    fun mapRemoteHeroesToHeroes(heroeRemoteList: List<HeroeRemote>): List<Heroe>{
        return heroeRemoteList.map{mapRemoteHeroeToHeroe(it)}
    }
    fun mapRemoteHeroeToHeroe(heroeRemote: HeroeRemote): Heroe{
        return Heroe(
            heroeRemote.id,
            heroeRemote.name,
            heroeRemote.description,
            heroeRemote.modified,
            heroeRemote.thumbnail
        )
    }
}