package com.albertojr.proyectoandroidsuperpoderes.repository.local

import android.util.Log
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.local.models.HeroeLocal
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroeLocalToHeroe
import com.albertojr.proyectoandroidsuperpoderes.repository.mappers.HeroesToHeroeLocal
import javax.inject.Inject

class DefaultLocalDataSource @Inject constructor(
    private val dao: HeroeDAO
) : LocalDataSource {
    override suspend fun getHeroes(): List<Heroe> {
        return HeroeLocalToHeroe().mapHeroesLocalToHeroes(dao.getHeroes())
    }

    override suspend fun insertHeroes(heroes: List<Heroe>) {
        //TODO add maper from heroe to HeroeLocal

        return dao.insertAllHeroes(HeroesToHeroeLocal().mapHeroesToHeroesLocal(heroes))
    }

    override suspend fun getHeroe(id: Long): Heroe {

        return HeroeLocalToHeroe().mapHeroeLocalToHeroe(dao.getHeroe(id))
    }

    override suspend fun updateHeroeFavStateLocal(id: Long, isFav: Boolean) {
        Log.d("Fav", "Inside DefaultLocalDataSource")
        return dao.updateHeroeFavStateLocal(id, isFav)
    }
}