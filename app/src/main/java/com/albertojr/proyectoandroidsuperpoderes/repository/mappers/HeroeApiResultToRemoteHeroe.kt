package com.albertojr.proyectoandroidsuperpoderes.repository.mappers

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.HeroesApiResult
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteHeroe
import javax.inject.Inject

class HeroeApiResultToRemoteHeroe @Inject constructor() {
    fun mapHeroeApiResultToRemoteHeroe(heroesApiResult: HeroesApiResult):List<RemoteHeroe>{
        return heroesApiResult.data.results
    }

}