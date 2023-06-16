package com.albertojr.proyectoandroidsuperpoderes.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Repository
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroeListViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    private val _state = MutableStateFlow<List<Heroe>>(emptyList())
    val state: StateFlow<List<Heroe>> get() = _state


    private val _stateComics = MutableStateFlow<List<Comic>>(emptyList())
    val stateComics: StateFlow<List<Comic>> get() = _stateComics


    private val _stateSeries = MutableStateFlow<List<Serie>>(emptyList())
    val stateSeries: StateFlow<List<Serie>> get() = _stateSeries


    private val _stateHeroe = MutableStateFlow<Heroe>(Heroe(-1,"","", "",))
    val stateHeroe: StateFlow<Heroe> get() = _stateHeroe



    fun retrieveHeroes(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.retrieveHeroes()
            }
            _state.update {result}
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

}