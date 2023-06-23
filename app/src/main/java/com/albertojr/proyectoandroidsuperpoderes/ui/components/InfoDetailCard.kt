package com.albertojr.proyectoandroidsuperpoderes.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe


@Composable
fun InfoDetailCard(heroe: Heroe) {
    InfoDetailCardContent(heroe)
}

@Composable
fun InfoDetailCardContent(heroe: Heroe) {
    //TODO fix adding dynamics values at run time
    val width = LocalConfiguration.current.screenWidthDp.dp
    val height = LocalConfiguration.current.screenHeightDp.dp / 2.4f
    Card(modifier = Modifier
        // .height(300.dp)
        .height(height)
        .width(width)
        //.fillMaxWidth()
        .background(Color.White)

        .padding(8.dp)
    ) {

       Column(modifier = Modifier.fillMaxSize().background(Color.Red.copy(alpha = 0.3f))) {
           AsyncImage(model = heroe.picture, modifier = Modifier.align(Alignment.CenterHorizontally).padding(5.dp), contentDescription = "${heroe.name} picture", contentScale = ContentScale.Fit)
           Text(text = "${heroe.name}", style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.ExtraBold), modifier = Modifier.align(Alignment.CenterHorizontally))

           if(heroe.description.isNotEmpty()){
               Text(text = "${heroe.description}",
                   modifier = Modifier.verticalScroll(rememberScrollState()).padding(10.dp))
           }else{
               Text(text = "${heroe.name} has no description",
                   modifier = Modifier.padding(10.dp))
           }
       }

    }
}

@Preview
@Composable
fun InfoDetailCard_Preview() {
    val heroe = Heroe(121221,"goku", "Is the best", "url here", false)

    InfoDetailCardContent(heroe)
}
