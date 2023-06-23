package com.albertojr.proyectoandroidsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.albertojr.proyectoandroidsuperpoderes.ui.navigation.NavigationGraph
import com.albertojr.proyectoandroidsuperpoderes.ui.theme.ProyectoAndroidSuperpoderesTheme
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val heroeListViewModel : HeroeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoAndroidSuperpoderesTheme {
                NavigationGraph(heroeListViewModel = heroeListViewModel)
            }
        }
    }
}