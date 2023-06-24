package com.albertojr.proyectoandroidsuperpoderes.fakes

import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

open class FakeLocalDataSource: LocalDataSource {

    private val heroesList: Flow<List<Heroe>> = flow{
        emit(listOf(
            Heroe(1, "Goku", "Descripción de Goku", "https://gokupicture.jp", false),
            Heroe(2, "Vegeta", "Descripción de Vegeta", "https://vegetapicture.jp", false),
            Heroe(3, "Bulma", "Descripción de Bulma", "https://bulmapicture.jp", false),
            Heroe(4, "Célula", "Descripción de Célula", "https://celulapicture.jp", false),
            Heroe(5, "Mr.Satán", "Descripción de Mr. Statán", "https://mrsatanpicture.jp", false)
        ))
    }

    private val heroeListAfterLike: Flow<List<Heroe>> = flow { emit(emptyList()) }

    private val sheredHeroes = MutableSharedFlow<List<Heroe>>()

    override suspend fun getHeroes(): List<Heroe> {
        var result = emptyList<Heroe>()
        heroesList.collect{
           result =  it
        }
        return result
    }
    suspend fun getHeroesAfterLikeCall(id: Long, isFav: Boolean): List<Heroe> {
        var result = emptyList<Heroe>()
        heroesList.map {
            val indexToChange = it.indexOfFirst {it.id == id }
            it[indexToChange].isFavourite = isFav
            it
        }.collect{
           result =  it
        }
        return result
    }
    suspend fun emit(heroeList: List<Heroe>){
        sheredHeroes.emit(heroeList)
    }
    override suspend fun insertHeroes(heroes: List<Heroe>) {
            TODO("Not yet implemented")
    }

    override suspend fun getHeroe(id: Long): Heroe {
        var result: Heroe = Heroe (-1, "Error", "Error", "Error", false)
        heroesList.map {
            it.first{ it.id == id}
        }.collect{
            result = it
        }
        return result
    }

    override suspend fun updateHeroeFavStateLocal(id: Long, isFav: Boolean) {
        heroesList.map{
            val indexToChange = it.indexOfFirst {it.id == id }
            it[indexToChange].isFavourite = isFav
            it
        }.collect{
            //heroeListAfterLike.map { it }
            emit(it)
        }
    }
}