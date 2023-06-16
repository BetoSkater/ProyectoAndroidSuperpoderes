package com.albertojr.proyectoandroidsuperpoderes.ui.navigation

sealed class Screens(val route: String) {
    object HeroesListScreen : Screens(SCREEN1_BASE_ROUTE)

    companion object{
        private const val SCREEN1_BASE_ROUTE = "HeroesListScreen"
    }
}