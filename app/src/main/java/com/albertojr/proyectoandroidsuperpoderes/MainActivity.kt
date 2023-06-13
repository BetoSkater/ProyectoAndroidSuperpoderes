package com.albertojr.proyectoandroidsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.ui.theme.ProyectoAndroidSuperpoderesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val heroeListViewModel : HeroeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoAndroidSuperpoderesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    apiTestRetrieveAllHeroesVM(heroeListViewModel)
                }
            }
        }
    }
}






@Composable
fun apiTestRetrieveAllHeroesVM(viewModel: HeroeListViewModel, modifier: Modifier = Modifier) {
    val state by viewModel.state.collectAsState()
    val stateComics by viewModel.stateComics.collectAsState()
    val stateSeries by viewModel.stateSeries.collectAsState()

    LaunchedEffect(Unit){
        //viewModel.retrieveHeroes()
      //  viewModel.retrieveHeroeComics(1011758)
        viewModel.retrieveHeroeComics(1017857)

        viewModel.retrieveHeroeSeries(1011758)
       // viewModel.retrieveHeroeSeries(1017857)
    }

    //TODO Qhat does it do? Call the base Composable used by both, the preview and the app


    apiTestHeroeSeries(stateSeries){serie ->

    }

/*
    apiTestHeroeSeries(stateComics){ heroe ->

    }

 */

    /*
    apiTestRetrieveAllHeroes(state){heroe ->

    }

     */
}


@Composable
fun apiTestHeroeSeries(comics: List<Serie>, onitemClicled: (String)->Unit){
    Column() {
        Text(text = "Series List")
        LazyColumn(){
            items(items = comics, key = {it.id}){serie ->
                SerieItem(serie = serie)
            }
        }
    }
}
@Composable
fun SerieItem(serie: Serie){
    Text(text = serie.title)
}



/*
@Composable
fun apiTestHeroeComics(comics: List<Comic>, onitemClicled: (String)->Unit){
    Column() {
        Text(text = "Comics List")
        LazyColumn(){
            items(items = comics, key = {it.id}){comic ->
                comicItem(comic = comic)
            }
        }
    }
}
@Composable
fun comicItem(comic: Comic){
    Text(text = comic.title)
}


 */


/*
@Composable
fun apiTestRetrieveAllHeroes(heroes: List<Heroe>, onitemClicled: (String)->Unit){
    Column() {
        Text(text = "Heroes List")
        LazyColumn(){
            items(items = heroes, key = {it.id}){heroe ->
                heroeItem(heroe = heroe)
            }
        }
    }
}
@Composable
fun heroeItem(heroe: Heroe){
    Text(text = heroe.name)
}



 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ProyectoAndroidSuperpoderesTheme {
        //apiTestHeroeComics(emptyList(), {})
    }
}


