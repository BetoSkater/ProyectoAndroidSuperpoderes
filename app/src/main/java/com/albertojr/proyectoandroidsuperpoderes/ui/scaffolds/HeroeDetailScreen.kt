package com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albertojr.proyectoandroidsuperpoderes.ItemCard
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomBottomBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomTopBar
import com.albertojr.proyectoandroidsuperpoderes.ui.mappers.GenericToItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel

@Composable
fun HeroeDetailScreen(heroeListViewModel: HeroeListViewModel) {
    //val state by heroeListViewModel.state.collectAsState()
    val stateHeroe by heroeListViewModel.stateHeroe.collectAsState()

    val stateComics by heroeListViewModel.stateComics.collectAsState()
    val stateSeries by heroeListViewModel.stateSeries.collectAsState()
    HeroeDetailScreenContent(stateHeroe, stateComics, stateSeries)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroeDetailScreenContent(heroe: Heroe, comicList: List<Comic>, seriesList: List<Serie>) {

    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = { CustomBottomBar() },
        modifier = Modifier.fillMaxSize(),

        ) {




        LazyColumn(){
//            items(items = heroes, key = {it.id}){heroe ->
//                ItemCard(GenericToItemCardData().ItemCardMapper(heroe))
//            }
        }
    }
}

@Preview
@Composable
fun HeroeDetailScreen_Preview() {
    //HeroeDetailScreenContent()
}

//Heroe Detail



//Comics and Series Grids