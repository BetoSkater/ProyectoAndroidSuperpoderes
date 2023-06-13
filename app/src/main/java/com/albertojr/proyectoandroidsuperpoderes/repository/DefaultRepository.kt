package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.RemoteHeroeToHeroe
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteDataSource
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteHeroe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): Repository {
    override suspend fun retrieveHeroes(): List<Heroe> {
        return RemoteHeroeToHeroe().mapRemoteHeroesToHeroes(remoteDataSource.retrieveHeroes())
    }
}