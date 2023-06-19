package com.albertojr.proyectoandroidsuperpoderes.ui.navigation

import com.albertojr.proyectoandroidsuperpoderes.ui.navigation.Screens.HeroesDetailScreen.ARG_HEROE_ID

sealed class Screens(val route: String) {
    object HeroesListScreen : Screens(SCREEN1_BASE_ROUTE)
    object HeroesDetailScreen : Screens(SCREEN2_ROUTE_TEMPLATE){
        const val ARG_HEROE_ID = "heroeId"
        fun createRouteWithArgs(heroeId: Long): String{ //TODO check
        //   return SCREEN2_ROUTE_TO_FORMAT.format(heroeId) //Returns HeroesDetailScreen/heroeId
            return "HeroesDetailScreen/$heroeId"
        }
    }
    companion object{
        private const val SCREEN1_BASE_ROUTE = "HeroesListScreen"
        private const val SCREEN2_BASE_ROUTE = "HeroesDetailScreen"
        private const val SCREEN2_ROUTE_TEMPLATE = "$SCREEN2_BASE_ROUTE/{$ARG_HEROE_ID}"
        private const val SCREEN2_ROUTE_TO_FORMAT = "$SCREEN2_BASE_ROUTE/$ARG_HEROE_ID"
    }
}