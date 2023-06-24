package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.local.models.HeroeLocal
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.HeroeRemote

class HeroeRemoteToHeroeLocal {

    fun mapHeroeRemoteToHeroesLocal(heroeRemoteList: List<HeroeRemote>): List<HeroeLocal>{
        return heroeRemoteList.map{mapHeroeRemoteToHeroeLocal(it)}
    }
    private fun mapHeroeRemoteToHeroeLocal(heroeRemote: HeroeRemote): HeroeLocal {
        return HeroeLocal(
            heroeRemote.id,
            heroeRemote.name,
            heroeRemote.description,
            ThubmailToURL().generateImageURLFromThumnail(heroeRemote.thumbnail)
        )
    }
}