package com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.albertojr.proyectoandroidsuperpoderes.R
import com.albertojr.proyectoandroidsuperpoderes.ui.components.ItemCard
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomBottomBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomTopBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.InfoDetailCard
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel

@Composable
fun HeroeDetailScreen(heroeID: Long, heroeListViewModel: HeroeListViewModel, onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    val stateHeroe by heroeListViewModel.stateHeroe.collectAsState()
    val stateComics by heroeListViewModel.stateComics.collectAsState()
    val stateSeries by heroeListViewModel.stateSeries.collectAsState()
    val stateLikedHeroe by heroeListViewModel.stateLikedHeroe.collectAsState()

    LaunchedEffect(Unit){
        heroeListViewModel.retrieveHeroeWithID(heroeID)
        heroeListViewModel.retrieveHeroeComics(heroeID)
        heroeListViewModel.retrieveHeroeSeries(heroeID)
        heroeListViewModel.setLikedHeroeIfHeroeWasLiked(heroeID)
    }

    HeroeDetailScreenContent(stateHeroe, stateComics, stateSeries,stateLikedHeroe,onBackToHeroeListClicled){
        heroeListViewModel.updateHeroeFavStateLocal(stateHeroe.id,stateHeroe.isFavourite)
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HeroeDetailScreenContent(heroe: Heroe, comicList: List<ItemCardData>, seriesList: List<ItemCardData>, isLikedHeroe: Boolean,onBackToHeroeListClicled: (Unit) -> (Unit) = {}, setFav: (Unit) -> (Unit) = {}) {
    Scaffold(
        topBar = { CustomTopBar(true,onBackToHeroeListClicled) },
        bottomBar = { CustomBottomBar(true, isLikedHeroe, onBackToHeroeListClicled){
            heroe.isFavourite = !heroe.isFavourite
            setFav(Unit)
            Log.d("Fav","Clicked ${heroe.name}, with id: ${heroe.id}" )
        } },
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color.LightGray),
        ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = it)){
            //Heroe Detail Info
            InfoDetailCard(heroe = heroe)
            //Heroe detail Comics and series
            TabMenu( comicList, seriesList)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeroeDetailScreen_Preview() {
    val heroe = Heroe(121221,"goku", "Is the best", "url here", false)
    HeroeDetailScreenContent(heroe, emptyList(), emptyList(),false)
}
//--------------------------------------------------------------------
//Comics and Series Tabs
@Composable
fun TabMenu(comicsList: List<ItemCardData>, seriesList: List<ItemCardData>) {
        TabMenuContent(comicsList,seriesList)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabMenuContent(comicsList: List<ItemCardData>, seriesList: List<ItemCardData>) {
        DetailViewTabs(comicsList, seriesList)
}

@Preview
@Composable
fun TabMenu_Preview() {
    val comicListTest = emptyList<ItemCardData>()
    val serieListTest = emptyList<ItemCardData>()
    TabMenuContent(comicListTest,serieListTest)
}
// ------------------------------------------------------------------------------
@Composable
fun DetailViewTabs(comicsList: List<ItemCardData>, seriesList: List<ItemCardData>){
    DetailViewTabsContent(comicsList, seriesList)
}

@Composable
fun DetailViewTabsContent(comicsList: List<ItemCardData>, seriesList: List<ItemCardData>){
    var state by remember { mutableStateOf(0) }
    val titles = listOf(stringResource(id = R.string.detail_comics), stringResource(id = R.string.detail_series))
    Column {
        TabRow(selectedTabIndex = state,
        contentColor = Color.Red,
        modifier = Modifier.testTag("detail_tab_row")) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { //TODO decouple the text component
                        Text(title,
                            modifier = Modifier.height(40.dp),
                            fontWeight = if (state == index) {FontWeight.Bold} else {FontWeight.Thin
                            } )
                    },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }
        when(state){
            0 -> TabContent(itemCardData = comicsList)
            1 -> TabContent(itemCardData = seriesList)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun DetailViewTabs_Preview(){
    val comicListTest = emptyList<ItemCardData>()
    val serieListTest = emptyList<ItemCardData>()
    DetailViewTabsContent(comicListTest, serieListTest)
}

//---------------------------------------------------------------

@Composable
fun TabContent(itemCardData: List<ItemCardData>) {
    TabContentContent(itemCardData)
}

@Composable
fun TabContentContent(itemCardData: List<ItemCardData>) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        items(items = itemCardData, key = {it.id}){element ->
            ItemCard(element) {} //empty on click, not action requiered in here.
        }
    }
}

@Preview
@Composable
fun TabContent_Preview() {
    val test = listOf<ItemCardData>(
        ItemCardData(1,"Comic ", ""),
        ItemCardData(1,"Comic ", "")
    )
    TabContentContent(test)
}
