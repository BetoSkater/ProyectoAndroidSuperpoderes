package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeApiResultToRemoteHeroe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRemoteDataSource @Inject constructor(private val api: MarvelApi): RemoteDataSource {
    override suspend fun retrieveHeroes(): List<RemoteHeroe> {
        val ts = 1
        // Apikey
        val apikey = ""
        // Hash
        val hash = ""
        // OrderBy
        val orderBy= ""

        val result = api.retrieveHeroes(ts, apikey,hash,orderBy)
        return HeroeApiResultToRemoteHeroe().mapHeroeApiResultToRemoteHeroe(result)
    }


}



