package com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albertojr.proyectoandroidsuperpoderes.ItemCard
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomBottomBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomTopBar
import com.albertojr.proyectoandroidsuperpoderes.ui.mappers.GenericToItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel

@Composable
fun HeroesListScreen(heroeListViewModel: HeroeListViewModel) {

    val state by heroeListViewModel.state.collectAsState()

    LaunchedEffect(Unit){
        heroeListViewModel.retrieveHeroes()
    }

    HeroesListScreenContent(state,){ heroe ->

    } //TODO pass viewmodel value
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesListScreenContent(heroes: List<Heroe>, onHeroeListClicked: (Heroe) -> Unit){

  //  val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = {CustomBottomBar()},
        modifier = Modifier.fillMaxSize(),

        ) {
        LazyColumn(){
            items(items = heroes, key = {it.id}){heroe ->
                ItemCard(GenericToItemCardData().ItemCardMapper(heroe))
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