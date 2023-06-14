package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeRemoteToHeroe
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): Repository {
    override suspend fun retrieveHeroes(): List<Heroe> {
        return remoteDataSource.retrieveHeroes()
    }

    override suspend fun retrieveHeroeComics(heroeId: Long): List<Comic> {
        return remoteDataSource.retrieveHeroeComics(heroeId)
    }

    override suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie> {
        return remoteDataSource.retrieveHeroeSeries(heroeId)
    }
}