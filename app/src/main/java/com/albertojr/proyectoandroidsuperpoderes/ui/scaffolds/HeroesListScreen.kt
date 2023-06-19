package com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import com.albertojr.proyectoandroidsuperpoderes.ItemCard
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomBottomBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomTopBar
import com.albertojr.proyectoandroidsuperpoderes.ui.mappers.GenericToItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.navigation.NavigationGraph
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel

@Composable
//fun HeroesListScreen(heroeListViewModel: HeroeListViewModel,onHeroeListClicked: (Long) -> Unit = {_ ->}) {
fun HeroesListScreen(heroeListViewModel: HeroeListViewModel,onHeroeListClicked: (Long) -> Unit ) {

    val state by heroeListViewModel.state.collectAsState()
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

  //  val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = {CustomBottomBar()},
        modifier = Modifier.fillMaxSize()
//            .clickable {
//            Log.d("Clicked", "Cliced Scafold")
//
//        },

        ) {
        LazyColumn(
            modifier = Modifier, contentPadding = it
        ){
//            item {
//                val heroe = Heroe(121221,"goku", "Is the best", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.cartonionline.com%2Fes%2Fwordpress%2Fbola-de-drag%25C3%25B3n-de-goku%2F&psig=AOvVaw2Ya1EKOmoWjbpPukKuzMDK&ust=1687079533840000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCIi9qJT7yf8CFQAAAAAdAAAAABAK", false)
//
//                ItemCard(GenericToItemCardData().ItemCardMapper(heroe), onHeroeListClicked)
//            }
            items(items = heroes, key = {it.id}){heroe ->
//              Surface(modifier = Modifier.clickable {
//                  Log.d("Clicked", "Cliced surface")
//              }) {
//                  ItemCard(GenericToItemCardData().ItemCardMapper(heroe))
//
//              }
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