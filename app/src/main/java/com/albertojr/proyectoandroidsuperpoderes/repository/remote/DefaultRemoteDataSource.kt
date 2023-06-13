package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import androidx.compose.ui.text.resolveDefaults
import com.albertojr.proyectoandroidsuperpoderes.BuildConfig
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.ComicResultToComic
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeApiResultToRemoteHeroe
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.SerieResultToSerie
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRemoteDataSource @Inject constructor(private val api: MarvelApi): RemoteDataSource {
    override suspend fun retrieveHeroes(): List<RemoteHeroe> {
        //val ts = getTimeStamp()
        val ts : Long = 1
        val apikey = getApiKey()
        val hash = generateHashMD5()
        val orderBy= "-modified" //TODO change if needed

        val result = api.retrieveHeroes(ts, apikey,hash,orderBy)
        return HeroeApiResultToRemoteHeroe().mapHeroeApiResultToRemoteHeroe(result)
    }

    override suspend fun retrieveHeroeComics(heroeId: Long): List<Comic> {
       // val ts = getTimeStamp()
        val ts:Long = 1
        val apikey = getApiKey()
        val hash = generateHashMD5()
        val orderBy= "onsaleDate" //TODO change if needed

        val result = api.retrieveHeroeComics(heroeId,ts,apikey,hash,orderBy)
        return ComicResultToComic().mapComicResultToComics(result.data.results) //TODO refactor the result.data.results
    }

    override suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie> {
       // val ts = getTimeStamp()
        val ts : Long = 1
        val apikey = getApiKey()
        val hash = generateHashMD5()
        val orderBy= "startYear" //TODO change if needed

        val result = api.retrieveHeroeSeries(heroeId,ts,apikey,hash,orderBy).data.results //TODO refactor the result.data.results
        return SerieResultToSerie().mapSerieResultToSeries(result)
    }


    //RequestData
    private fun getTimeStamp(): Long{
        return System.currentTimeMillis()
    }
    private fun getApiKey(): String {
        return BuildConfig.puclic_key
    }
    private fun generateHashMD5():String{
        val md5 = MessageDigest.getInstance("MD5")
       // val valueToHash = "${getTimeStamp()}${BuildConfig.private_key}${BuildConfig.puclic_key}"
        val valueToHash = "1${BuildConfig.private_key}${BuildConfig.puclic_key}" // With ts = 1, i get the same hash I got back then.
        val bigInt = BigInteger(1,md5.digest(valueToHash.toByteArray(Charsets.UTF_8)))
        return String.format("%32x",bigInt)
    }
}



