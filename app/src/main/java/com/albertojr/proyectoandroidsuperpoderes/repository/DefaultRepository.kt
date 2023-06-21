package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.local.LocalDataSource
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeRemoteToHeroe
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeRemoteToHeroeLocal
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroesToHeroeLocal
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteDataSource
import com.albertojr.proyectoandroidsuperpoderes.ui.mappers.GenericToItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
): Repository {

    override suspend fun retrieveHeroes(): List<Heroe> {
       if(localDataSource.getHeroes().isEmpty()){
           localDataSource.insertHeroes(remoteDataSource.retrieveHeroes())
            return remoteDataSource.retrieveHeroes()
       }

        return localDataSource.getHeroes()
    }

    override suspend fun retrieveHeroeById(id: Long): Heroe {
        return localDataSource.getHeroe(id)
    }


//    override suspend fun retrieveHeroeComics(heroeId: Long): List<Comic> {
//        return remoteDataSource.retrieveHeroeComics(heroeId)
//    }
//
//    override suspend fun retrieveHeroeSeries(heroeId: Long): List<Serie> {
//        return remoteDataSource.retrieveHeroeSeries(heroeId)
//    }
//
    override suspend fun retrieveHeroeComics(heroeId: Long): List<ItemCardData> {
        return GenericToItemCardData().GenericListToItemCardMapper(remoteDataSource.retrieveHeroeComics(heroeId))
    }

    override suspend fun retrieveHeroeSeries(heroeId: Long): List<ItemCardData> {
        return GenericToItemCardData().GenericListToItemCardMapper(remoteDataSource.retrieveHeroeSeries(heroeId))

    }
}