package com.albertojr.proyectoandroidsuperpoderes.ui.components

import android.util.DisplayMetrics
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local


@Composable
fun InfoDetailCard(heroe: Heroe) {
    InfoDetailCardContent(heroe)
}

@Composable
fun InfoDetailCardContent(heroe: Heroe) {
    //TODO fix adding dynamics values at run time
   // val width = LocalConfiguration.current.screenWidthDp.dp
   // val height = LocalConfiguration.current.screenHeightDp.dp / 2
    Card(modifier = Modifier.height(300.dp).fillMaxWidth()) {
        AsyncImage(model = heroe.picture, contentDescription = "${heroe.name} picture")
        Text(text = "${heroe.name}")
        if(heroe.description.isNotEmpty()){
            Text(text = "${heroe.description}")

        }else{
            Text(text = "${heroe.name} has no description")
        }

    }
}

@Preview
@Composable
fun InfoDetailCard_Preview() {
    val heroe = Heroe(121221,"goku", "Is the best", "url here", false)

    InfoDetailCardContent(heroe)
}
//
//fun halfWidth(): Dp {
//    //val width = DisplayMetrics().widthPixels / 2
//    return LocalConfiguration.current.screenWidthDp.dp
//}