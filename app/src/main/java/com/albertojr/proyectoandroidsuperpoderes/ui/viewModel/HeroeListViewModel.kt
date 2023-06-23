package com.albertojr.proyectoandroidsuperpoderes.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Repository
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.ui.mappers.GenericToItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class HeroeListViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    private val _state = MutableStateFlow<List<Heroe>>(emptyList())
    val state: StateFlow<List<Heroe>> get() = _state


//    private val _stateComics = MutableStateFlow<List<Comic>>(emptyList())
//    val stateComics: StateFlow<List<Comic>> get() = _stateComics
//
//    private val _stateSeries = MutableStateFlow<List<Serie>>(emptyList())
//    val stateSeries: StateFlow<List<Serie>> get() = _stateSeries


    //    private val _stateComics = MutableStateFlow<List<Comic>>(emptyList()).map { GenericToItemCardData().GenericListToItemCardMapper(stateComics) }
//    val stateComics: StateFlow<List<ItemCardData>> get() = _stateComics

    private val _stateComics = MutableStateFlow<List<ItemCardData>>(emptyList())
    val stateComics: StateFlow<List<ItemCardData>> get() = _stateComics

    private val _stateSeries = MutableStateFlow<List<ItemCardData>>(emptyList())
    val stateSeries: StateFlow<List<ItemCardData>> get() = _stateSeries

    private val _stateHeroe = MutableStateFlow<Heroe>(Heroe(-1,"","", "",))
    val stateHeroe: StateFlow<Heroe> get() = _stateHeroe

    private val _stateLikedHeroe = MutableStateFlow<Boolean>(false)
    val stateLikedHeroe: StateFlow<Boolean> get() = _stateLikedHeroe


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

     fun updateHeroeFavStateLocal(id: Long, isFav: Boolean){
         viewModelScope.launch(Dispatchers.IO) {
             repository.updateHeroeFavStateLocal(id, isFav)
             _stateLikedHeroe.update { isFav }
           //  _stateHeroe.value.isFavourite == isFav
         }
       //  updateHeroeListAfterHeroeWasLiked()

     }

    fun setLikedHeroeIfHeroeWasLiked(heroeID: Long){
        viewModelScope.launch(Dispatchers.IO) {

//           stateHeroe.transform { emit(stateHeroe.value.isFavourite) }.collect(){
//                _stateLikedHeroe.update { it }
//
//            }
            stateHeroe.filter {heroe ->
                heroe.id == heroeID
            }.collect(){foundHeroe ->
                _stateLikedHeroe.update { foundHeroe.isFavourite }
            }

        }
    }

    fun updateHeroeListAfterHeroeWasLiked(){
        viewModelScope.launch(Dispatchers.IO) {

          val valueToUpdate = stateHeroe.transform {
               emit(stateHeroe)

           }.collect()

            state.map { heroeList ->
                heroeList.find { listHeroe ->
                    listHeroe.id == stateHeroe.value.id }?.isFavourite = stateHeroe.value.isFavourite
            }.collect(){
                _state.update { it }

            }


        }
    }


}