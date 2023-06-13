package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    //https://gateway.marvel.com/v1/public/characters
    //Base URL
    //https://gateway.marvel.com/v1
    // PAth
    // /public/characters
    // ts
    // ?ts=timeStamp
    // Apikey
    // &apikey=apiKeyValue
    // Hash
    // &hash=hash_value
    // OrderBy
    // &orderBy=-modified

    @GET("/v1/public/characters")
    suspend fun retrieveHeroes(@Query("ts") ts: Long,
                               @Query("apikey") apikey: String,
                               @Query("hash") hash: String,
                               @Query("orderBy") orderBy: String
    ): HeroesApiResult



}