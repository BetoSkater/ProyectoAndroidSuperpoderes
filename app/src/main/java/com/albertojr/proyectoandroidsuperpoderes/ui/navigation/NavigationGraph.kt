package com.albertojr.proyectoandroidsuperpoderes.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroeDetailScreen
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroesListScreen
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel

@Composable
fun NavigationGraph(heroeListViewModel: HeroeListViewModel) {
    val navController = rememberNavController()

    NavHost(navController, Screens.HeroesListScreen.route) {
        composable(Screens.HeroesListScreen.route) {
            HeroesListScreen(heroeListViewModel = heroeListViewModel) {
              Log.d("Clicked", "Hero with id $it clicked")
              //TODO remove
                val route = Screens.HeroesDetailScreen.createRouteWithArgs(it)
                Log.d("Clicked", "$route")

               navController.navigate(Screens.HeroesDetailScreen.createRouteWithArgs(it))
              // navController.navigate("HeroesDetailScreen/$it")

            }

        }
        composable(Screens.HeroesDetailScreen.route, arguments = listOf(
            navArgument(Screens.HeroesDetailScreen.ARG_HEROE_ID){
                this.type = NavType.LongType
            }
        )) {
            val heroeID = it.arguments?.getLong(Screens.HeroesDetailScreen.ARG_HEROE_ID)
            Log.d("Clicked", "Argument: ${it.destination.arguments.values} $heroeID")

            if (heroeID != null) {
                HeroeDetailScreen( heroeID,heroeListViewModel = heroeListViewModel){
                    navController.navigateUp()
                }
            } else{
                navController.navigateUp()
            }
        }
    }
}