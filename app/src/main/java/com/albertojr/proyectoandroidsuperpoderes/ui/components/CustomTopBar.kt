package com.albertojr.proyectoandroidsuperpoderes.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomTopBar(isExtendedTopBar: Boolean = false, onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    CustomTopBarContent(isExtendedTopBar, onBackToHeroeListClicled)
}
//TODO detail view needs at leat a MediumTopAppBar, because it has the return funtionality
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBarContent(isExtendedTopBar: Boolean = false,onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    if(isExtendedTopBar){
//        MediumTopAppBar(
        TopAppBar(
            title = {
                Text("Detailed Heroe") //TODO past string id as parameter
            },
            navigationIcon = {BackButtonTopBar(onBackToHeroeListClicled)}


        )
    }else{
        TopAppBar(
            title = {
                Text("Marvel Heroes") //TODO past string id as parameter
            }
        )
    }



}

@Preview
@Composable
fun CustomTopBar_Preview() {
    CustomTopBarContent()
}
//-----------------------------

@Composable
fun BackButtonTopBar(onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    BackButtonTopBarContent(onBackToHeroeListClicled)
}

@Composable
fun BackButtonTopBarContent(onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    Icon(
        imageVector = Icons.Default.ArrowBack,
        tint = Color.Black,
        contentDescription = "Back button to heroe lsit",
        modifier = Modifier.clickable {
            onBackToHeroeListClicled(Unit)
        }
    )}

@Preview
@Composable
fun BackButtonTopBar_Preview() {
    BackButtonTopBarContent()
}

