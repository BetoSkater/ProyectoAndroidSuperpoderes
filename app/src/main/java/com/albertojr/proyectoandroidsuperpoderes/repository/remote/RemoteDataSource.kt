package com.albertojr.proyectoandroidsuperpoderes.repository.remote

import retrofit2.http.Header

interface RemoteDataSource {

    suspend fun retrieveHeroes(): List<RemoteHeroe>
}