package com.albertojr.proyectoandroidsuperpoderes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Repository
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

    fun retrieveHeroes(parameters: String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.retrieveHeroes()
            }
            _state.update {result}
        }
    }
}