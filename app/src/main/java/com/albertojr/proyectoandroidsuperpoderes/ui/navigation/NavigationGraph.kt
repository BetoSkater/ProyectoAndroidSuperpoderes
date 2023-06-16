package com.albertojr.proyectoandroidsuperpoderes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroesListScreen
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel

@Composable
fun NavigationGraph(heroeListViewModel: HeroeListViewModel) {
    val navController = rememberNavController()

    NavHost(navController, Screens.HeroesListScreen.route) {
        composable(Screens.HeroesListScreen.route) {
            HeroesListScreen(heroeListViewModel = heroeListViewModel)
        }

//        composable(Screens.HeroesListScreen.route) {
//            HeroesListScreen(viewModel = heroeListViewModel) {
//                // navController.navigate(Screens.HeroeDetail.route)
//            }
//        }


    }
}