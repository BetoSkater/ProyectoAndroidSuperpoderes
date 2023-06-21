package com.albertojr.proyectoandroidsuperpoderes.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomTopBar() {
    CustomTopBarContent()
}
//TODO detail view needs at leat a MediumTopAppBar, because it has the return funtionality
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBarContent() {
    TopAppBar(
        title = {
            Text("Marvel Heroes") //TODO past string id as parameter
        }
    )
}

@Preview
@Composable
fun CustomTopBar_Preview() {
    CustomTopBarContent()
}

