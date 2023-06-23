package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.HeroeRemote
import javax.inject.Inject

class HeroeRemoteToHeroe @Inject constructor() {
    fun mapHeroesRemoteToHeroes(heroeRemoteList: List<HeroeRemote>): List<Heroe>{
        return heroeRemoteList.map{mapHeroeRemoteToHeroe(it)}
    }
    private fun mapHeroeRemoteToHeroe(heroeRemote: HeroeRemote): Heroe{
        return Heroe(
            heroeRemote.id,
            heroeRemote.name,
            heroeRemote.description,
            ThubmailToURL().generateImageURLFromThumnail(heroeRemote.thumbnail)
        )
    }
}