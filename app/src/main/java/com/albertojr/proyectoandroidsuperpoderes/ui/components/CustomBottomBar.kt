package com.albertojr.proyectoandroidsuperpoderes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialogDefaults.containerColor

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomBar(hasFloatingButton: Boolean = false, isLikedIcon: Boolean = false,onBackToHeroeListClicled: (Unit) -> (Unit) = {}, onFloatingButtonClicked: (Boolean) -> (Unit) = {}) {
    CustomBottomBarContent(hasFloatingButton,isLikedIcon,onBackToHeroeListClicled, onFloatingButtonClicked)
}

@Composable
fun CustomBottomBarContent(hasFloatingButton: Boolean = false, isLikedIcon: Boolean = false, onBackToHeroeListClicled: (Unit) -> (Unit) = {}, onFloatingButtonClicked: (Boolean) -> (Unit) = {}) {
    //TODO this bar can hold a floating button, add the filter to fav heroes in that button
      BottomAppBar(
          actions = {TestAction(onBackToHeroeListClicled)},
          modifier = Modifier.background(Color.White),
          floatingActionButton = {if(hasFloatingButton){ CustomFloatingActionButton(isLikedIcon, onFloatingButtonClicked)}},
          )
}

@Preview
@Composable
fun CustomBottomBar_Preview() {
    CustomBottomBarContent()
}

//----------------------------------------------------
@Composable
fun CustomFloatingActionButton(isLikedIcon: Boolean = false, onFloatingButtonClicked: (Boolean) -> (Unit) = {}) {
    FloatingActionButton(onClick = { onFloatingButtonClicked(true) }) {
        Icon(
            imageVector = if(isLikedIcon){Icons.Default.Favorite } else {Icons.Default.FavoriteBorder} ,
            tint = Color.Red,
            contentDescription = "Filter fav heroes"
        )
    }
}

@Preview
@Composable
fun CustomFloatingActionButton_Preview() {
    CustomFloatingActionButton()
}

//------ GO HOME SCREEN BUTTON
@Composable
fun TestAction(onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    Row() {
        Icon(
            imageVector = Icons.Default.Home,
            tint = Color.Black,
            contentDescription = "Filter fav heroes",
            modifier = Modifier.clickable {
                onBackToHeroeListClicled(Unit)
            }
        )
    }
}