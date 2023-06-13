package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.HeroesApiResult
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteHeroe
import javax.inject.Inject

class RemoteHeroeToHeroe @Inject constructor() {

    fun mapRemoteHeroesToHeroes(remoteHeroeList: List<RemoteHeroe>): List<Heroe>{
        return remoteHeroeList.map{mapRemoteHeroeToHeroe(it)}
    }
    fun mapRemoteHeroeToHeroe(remoteHeroe: RemoteHeroe): Heroe{
        return Heroe(
            remoteHeroe.id,
            remoteHeroe.name,
            remoteHeroe.description,
            remoteHeroe.modified,
            remoteHeroe.thumbnail
        )
    }
}