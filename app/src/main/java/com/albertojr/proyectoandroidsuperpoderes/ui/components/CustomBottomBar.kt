package com.albertojr.proyectoandroidsuperpoderes.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
fun CustomBottomBar() {
    CustomBottomBarContent()
}

@Composable
fun CustomBottomBarContent() {
    //TODO this bar can hold a floating button, add the filter to fav heroes in that button


//    BottomAppBar(
//        actions = TestAction(),
//        modifier = Modifier,
//        floatingActionButton = { CustomFloatingActionButton() },
//        containerColor = BottomAppBarDefaults.containerColor,
//        contentColor = contentColorFor(containerColor),
//        tonalElevation = BottomAppBarDefaults.ContainerElevation,
//        contentPadding = BottomAppBarDefaults.ContentPadding,
//        windowInsets = BottomAppBarDefaults.windowInsets,
//    ) {

      BottomAppBar(
          actions = {TestAction()},
          modifier = Modifier,
          floatingActionButton = { CustomFloatingActionButton()},
          )

    }

  //  TODO remove this one, theone I want is the FAB one

//    BottomAppBar() {
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//            FloatingActionButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    imageVector = Icons.Default.Favorite,
//                    tint = Color.Red,
//                    contentDescription = "Filter fav heroes"
//                )
//            }
//        }
//    }

//}


@Preview
@Composable
fun CustomBottomBar_Preview() {
    CustomBottomBarContent()
}


@Composable
fun CustomFloatingActionButton() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Default.Favorite,
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


@Composable
fun TestAction() {
    Row() {
        Icon(
            imageVector = Icons.Default.Home,
            tint = Color.Black,
            contentDescription = "Filter fav heroes"
        )
    }
}