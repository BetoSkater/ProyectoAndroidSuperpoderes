package com.albertojr.proyectoandroidsuperpoderes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.albertojr.proyectoandroidsuperpoderes.R

@Composable
fun CustomBottomBar(hasFloatingButton: Boolean = false, isLikedIcon: Boolean = false,onBackToHeroeListClicled: (Unit) -> (Unit) = {}, onFloatingButtonClicked: (Boolean) -> (Unit) = {}) {
    CustomBottomBarContent(hasFloatingButton,isLikedIcon,onBackToHeroeListClicled, onFloatingButtonClicked)
}

@Composable
fun CustomBottomBarContent(hasFloatingButton: Boolean = false, isLikedIcon: Boolean = false, onBackToHeroeListClicled: (Unit) -> (Unit) = {}, onFloatingButtonClicked: (Boolean) -> (Unit) = {}) {
    //TODO this bar can hold a floating button, add the filter to fav heroes in that button
    BottomAppBar(
        actions = {GoToHomeScreenButton(onBackToHeroeListClicled)},
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
    FloatingActionButton(onClick = { onFloatingButtonClicked(true) },
    modifier = Modifier.testTag("fav_button")) {
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
fun GoToHomeScreenButton(onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    GoToHomeScreenButtonContent(onBackToHeroeListClicled)
}

@Composable
fun GoToHomeScreenButtonContent(onBackToHeroeListClicled: (Unit) -> (Unit) = {}) {
    Row() {
        Icon(
            imageVector = Icons.Default.Home,
            tint = Color.DarkGray,
            contentDescription = stringResource(id = R.string.go_to_characters_list ) ,
            modifier = Modifier.padding(20.dp).clickable {
                onBackToHeroeListClicled(Unit)
            }
        )
    }
}

@Preview
@Composable
fun GoToHomeScreenButton_Preview() {
    GoToHomeScreenButtonContent()
}