package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import android.util.Log
import com.albertojr.proyectoandroidsuperpoderes.BuildConfig
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.ComicResultToComic
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeRemoteToHeroe
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.SerieResultToSerie
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRemoteDataSource @Inject constructor(private val api: MarvelApi): RemoteDataSource {
    override suspend fun retrieveHeroes(): List<Heroe> {
        try {
            val ts = getTimeStamp()
            val apikey = getApiKey()
            val hash = generateHashMD5(ts)
            val orderBy= "-modified" //TODO change if needed

            val result = api.retrieveHeroes(ts, apikey,hash,orderBy)
            return HeroeRemoteToHeroe().mapHeroesRemoteToHeroes(result.data.results)
        }catch (exception: Exception){
            Log.w("Error", "Heroes Call error: $exception")
            return emptyList<Heroe>()
        }
    }

    override suspend fun retrieveHeroeComics(heroeId: Long): List<Comic> {

        try {
            val ts = getTimeStamp()
            val apikey = getApiKey()
            val hash = generateHashMD5(ts)
            val orderBy= "onsaleDate"

            val result = api.retrieveHeroeComics(heroeId,ts,apikey,hash,orderBy)
            return ComicResultToComic().mapComicResultToComics(result.data.results) //TODO refactor the result.data.results
        }catch (exception: Exception){
            Log.w("Error", "Comic Call error: $exception")
            return emptyList<Comic>()
        }
    }

    override suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie> {
        try {
            val ts = getTimeStamp()
            val apikey = getApiKey()
            val hash = generateHashMD5(ts)
            val orderBy= "startYear"

            val result = api.retrieveHeroeSeries(heroeId,ts,apikey,hash,orderBy).data.results //TODO refactor the result.data.results
            return SerieResultToSerie().mapSerieResultToSeries(result)
        }catch (exception: Exception){
            Log.w("Error", "Serie Call error: $exception")
            return emptyList<Serie>()
        }
    }
    //RequestData
    private fun getTimeStamp(): Long{
        return System.currentTimeMillis()
    }
    private fun getApiKey(): String {
        return BuildConfig.puclic_key
    }
    private fun generateHashMD5(ts: Long):String{
        val md5 = MessageDigest.getInstance("MD5")
        val valueToHash = "${ts}${BuildConfig.private_key}${BuildConfig.puclic_key}" // With ts = 1, i get the same hash I got back then.
        val bigInt = BigInteger(1,md5.digest(valueToHash.toByteArray(Charsets.UTF_8)))
        return String.format("%32x",bigInt)
    }
}