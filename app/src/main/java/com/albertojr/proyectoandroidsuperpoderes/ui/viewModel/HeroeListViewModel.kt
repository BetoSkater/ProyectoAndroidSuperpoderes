package com.albertojr.proyectoandroidsuperpoderes.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Repository
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroeListViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    private val _stateHeroeList = MutableStateFlow<List<Heroe>>(emptyList())
    val stateHeroeList: StateFlow<List<Heroe>> get() = _stateHeroeList

    private val _stateComics = MutableStateFlow<List<ItemCardData>>(emptyList())
    val stateComics: StateFlow<List<ItemCardData>> get() = _stateComics

    private val _stateSeries = MutableStateFlow<List<ItemCardData>>(emptyList())
    val stateSeries: StateFlow<List<ItemCardData>> get() = _stateSeries

    private val _stateHeroe = MutableStateFlow<Heroe>(Heroe(-1,"","", ""))
    val stateHeroe: StateFlow<Heroe> get() = _stateHeroe

    private val _stateLikedHeroe = MutableStateFlow<Boolean>(false)
    val stateLikedHeroe: StateFlow<Boolean> get() = _stateLikedHeroe


    fun retrieveHeroes(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.retrieveHeroes()
            }
            _stateHeroeList.update {result}
        }
    }

    fun retrieveHeroeComics(heroeId: Long){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.retrieveHeroeComics(heroeId)
            }
            _stateComics.update {result}
        }
    }

    fun retrieveHeroeSeries(heroeId: Long){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.retrieveHeroeSeries(heroeId)
            }
            _stateSeries.update {result}
        }
    }

    fun retrieveHeroeWithID(id: Long){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.retrieveHeroeById(id)
            }
            _stateHeroe.update { result }
        }
    }

    fun updateHeroeFavStateLocal(id: Long, isFav: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateHeroeFavStateLocal(id, isFav)
            _stateLikedHeroe.update { isFav }
        }
        updateHeroeListAfterHeroeWasLiked(id)
    }

    fun setLikedHeroeIfHeroeWasLiked(heroeID: Long){
        viewModelScope.launch(Dispatchers.IO) {
            stateHeroe.filter {heroe ->
                heroe.id == heroeID
            }.collect{foundHeroe ->
                _stateLikedHeroe.update { foundHeroe.isFavourite }
            }
        }
    }

    private fun updateHeroeListAfterHeroeWasLiked(heroeID: Long){
        viewModelScope.launch(Dispatchers.IO) {
            stateHeroeList.map { heroesListToMap ->
                val heroeIndex = heroesListToMap.indexOfFirst {targetHeroe ->
                    targetHeroe.id == heroeID }
                heroesListToMap[heroeIndex].isFavourite = !heroesListToMap[heroeIndex].isFavourite
            }.collect{
                _stateHeroeList.update {
                    it
                }
            }
        }
    }
}