package com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albertojr.proyectoandroidsuperpoderes.ui.components.ItemCard
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomBottomBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomTopBar
import com.albertojr.proyectoandroidsuperpoderes.ui.mappers.GenericToItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag


@Composable
//fun HeroesListScreen(heroeListViewModel: HeroeListViewModel,onHeroeListClicked: (Long) -> Unit = {_ ->}) {
fun HeroesListScreen(heroeListViewModel: HeroeListViewModel,onHeroeListClicked: (Long) -> Unit ) {

    val state by heroeListViewModel.stateHeroeList.collectAsState()
   //TODO add the item card mappers in here
    Log.d("Heroes", "primera ventana")
    LaunchedEffect(Unit){
        heroeListViewModel.retrieveHeroes()
    }

    HeroesListScreenContent(state){ heroeID ->
       // Log.d("Clicked", "Cliced heroesListScreen")

        onHeroeListClicked(heroeID)
    } //TODO pass viewmodel value

//    HeroesListScreenContent(state){ heroe ->
//        onHeroeListClicked(heroe.id)
//    } //TODO pass viewmodel value


}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesListScreenContent(heroes: List<Heroe>, onHeroeListClicked: (Long) -> Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = {CustomBottomBar()},
        modifier = Modifier.fillMaxSize()

        ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().background(Color.White).testTag("heroe_list_lazy_column"),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = it
        ){
            items(items = heroes, key = {it.id}){heroe ->
                ItemCard(GenericToItemCardData().ItemCardMapper(heroe),onHeroeListClicked)
            }
        }
    }
}
@Preview
@Composable
fun HeroesListScreen_Preview() {
    val heroe = Heroe(121221,"goku", "Is the best", "url here", false)
    val heroesTest = mutableListOf<Heroe>(heroe)
    HeroesListScreenContent(heroesTest, {})
}