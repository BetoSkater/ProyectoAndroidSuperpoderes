package com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomBottomBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomTopBar
import com.albertojr.proyectoandroidsuperpoderes.ui.components.InfoDetailCard
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel

@Composable
fun HeroeDetailScreen(heroeID: Long, heroeListViewModel: HeroeListViewModel) {
    //val state by heroeListViewModel.state.collectAsState()
    val stateHeroe by heroeListViewModel.stateHeroe.collectAsState()
    val stateComics by heroeListViewModel.stateComics.collectAsState()
   // val stateSeries by heroeListViewModel.stateSeries.map { GenericToItemCardData().ItemCardMapper(it) }.collectAsState()
    val stateSeries by heroeListViewModel.stateSeries.collectAsState()
    LaunchedEffect(Unit){
        heroeListViewModel.retrieveHeroeWithID(heroeID)
        heroeListViewModel.retrieveHeroeComics(heroeID)
        heroeListViewModel.retrieveHeroeSeries(heroeID)
    }

    HeroeDetailScreenContent(stateHeroe, stateComics, stateSeries)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
//fun HeroeDetailScreenContent(heroe: Heroe, comicList: List<Comic>, seriesList: List<Serie>) {
fun HeroeDetailScreenContent(heroe: Heroe, comicList: List<ItemCardData>, seriesList: List<ItemCardData>) {
    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = { CustomBottomBar() },
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),

        ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = it)){
            //Heroe Detail Info
            InfoDetailCard(heroe = heroe)
         //   TabRow(0, modifier = Modifier.height(150.dp)){TabMenuContent(comicList,seriesList)}
            TabMenu( comicList, seriesList)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeroeDetailScreen_Preview() {
    val heroe = Heroe(121221,"goku", "Is the best", "url here", false)

    HeroeDetailScreenContent(heroe, emptyList(), emptyList())
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
    //Two pages, Comics and Series
    val pagerState = rememberPagerState(initialPage = 0) //todo fix?

    Column(modifier = Modifier.fillMaxHeight()) {
        AditionDataTabs2()
      //  AditionalDataTabs(pagerState = pagerState)

//        HorizontalPager(modifier = Modifier
//            .height(200.dp)
//            .fillMaxWidth()
//            .background(Color.Yellow),
//            state = pagerState, pageCount = 2) { tabPage -> //TODO check pageCOunt
//
//            when(tabPage){
//                1 -> TabContentScreen(comicsList)//COmics
//                2 -> TabContentScreen(seriesList)//Series
//            }
//        }
    }

}

@Preview
@Composable
fun TabMenu_Preview() {
    val comicListTest = emptyList<ItemCardData>()
    val serieListTest = emptyList<ItemCardData>()

    TabMenuContent(comicListTest,serieListTest)
}

@Composable
fun TabContentScreen(itemCardData: List<ItemCardData>){
    Column(modifier = Modifier.height(200.dp)) {

        if(itemCardData.isNotEmpty()){
            Text(text = itemCardData[0].name)
        }else{
            Text(text = "Loading data")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AditionalDataTabs(pagerState: PagerState){
    val tabList = listOf(
        "Comics",
        "Series"
    )
    //TODO
    //VER LA DOCU DE ANDROID; EL TABROW lo mete en una COlumna
    //TODO
    val coroutineScope = rememberCoroutineScope()
        TabRow(selectedTabIndex = pagerState.currentPage,
            Modifier
                .fillMaxWidth()
                .height(145.dp)
                .background(Color.LightGray), contentColor = Color.Red,
            indicator = {tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    height = 5.dp,
                    color = Color.White
                )

            }) {
            tabList.forEachIndexed { index, value ->
        Tab(
            modifier = Modifier.height(55.dp),
            text = {
            Text(value,
                modifier = Modifier.height(40.dp),
            fontWeight = if (pagerState.currentPage == index) {FontWeight.Bold} else {FontWeight.Thin
            } )
        }, selected = pagerState.currentPage == index
            , onClick = { /*TODO*/ })

            }
        }

}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun AditionalDataTabs_Preview(){
    val pagerState = PagerState(0) //todo fix?

    AditionalDataTabs(pagerState = pagerState)
}

//Test with androird developers doc only

@Composable
fun AditionDataTabs2(){
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Comics", "Series")
    Column {
        TabRow(selectedTabIndex = state,
        contentColor = Color.Red) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = {
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
            0 -> {
                val test = listOf<ItemCardData>(
                    ItemCardData(1,"Comic ", ""),
                    ItemCardData(1,"Comic ", "")
                )
                TabContentScreen(itemCardData = test)
            }
            1 -> {
                val test2 = listOf<ItemCardData>(
                    ItemCardData(1,"Serie ", ""),
                    ItemCardData(1,"Serie ", "")
                )
                TabContentScreen(itemCardData = test2)
            }
        }



    }
}




@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun AditionalDataTabs2_Preview(){
    val pagerState = PagerState(0) //todo fix?
    AditionDataTabs2()
  //  AditionalDataTabs(pagerState = pagerState)
}