package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import android.graphics.Bitmap.Config
import android.util.Log
import androidx.compose.ui.platform.LocalConfiguration
import com.albertojr.proyectoandroidsuperpoderes.BuildConfig
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeApiResultToRemoteHeroe
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRemoteDataSource @Inject constructor(private val api: MarvelApi): RemoteDataSource {
    override suspend fun retrieveHeroes(): List<RemoteHeroe> {
        val ts = getTimeStamp()
        // Apikey
        val apikey = getApiKey()
        // Hash
        val hash = generateHashMD5()
        Log.d("HASH", "$hash")
        // OrderBy
        val orderBy= "-modified" //TODO change if needed

        val result = api.retrieveHeroes(ts, apikey,hash,orderBy)
        return HeroeApiResultToRemoteHeroe().mapHeroeApiResultToRemoteHeroe(result)
    }

    private fun getTimeStamp(): Long{
        return System.currentTimeMillis()
    }
    private fun getApiKey(): String {
        return BuildConfig.puclic_key
    }
    private fun generateHashMD5():String{
        val md5 = MessageDigest.getInstance("MD5")
        val valueToHash = "${getTimeStamp()}${BuildConfig.private_key}${BuildConfig.puclic_key}"
        //val valueToHash = "1${BuildConfig.private_key}${BuildConfig.puclic_key}" // With ts = 1, i get the same hash I got back then.
        val bigInt = BigInteger(1,md5.digest(valueToHash.toByteArray(Charsets.UTF_8)))
        return String.format("%32x",bigInt)
    }
}



