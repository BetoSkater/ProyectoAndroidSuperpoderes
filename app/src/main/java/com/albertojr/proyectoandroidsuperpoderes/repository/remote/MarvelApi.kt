package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.ApiResult
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.ComicRemote
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.HeroeRemote
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.models.SerieRemote
import retrofit2.http.GET
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
    ): ApiResult<HeroeRemote>

    //Retrieve comics in which the heroe makes an appearence by heroeID
    @GET("/v1/public/characters/{characterID}/comics")
    suspend fun retrieveHeroeComics(@Path("characterID") heroeID: Long,
                                    @Query("ts") ts: Long,
                                    @Query("apikey") apikey: String,
                                    @Query("hash") hash: String,
                                    @Query("orderBy") orderBy: String
    ): ApiResult<ComicRemote>

    //Retrieve comics in which the heroe makes an appearence by heroeID
    @GET("/v1/public/characters/{characterID}/series")
    suspend fun retrieveHeroeSeries(@Path("characterID") heroeID: Long,
                                    @Query("ts") ts: Long,
                                    @Query("apikey") apikey: String,
                                    @Query("hash") hash: String,
                                    @Query("orderBy") orderBy: String
    ): ApiResult<SerieRemote>
}