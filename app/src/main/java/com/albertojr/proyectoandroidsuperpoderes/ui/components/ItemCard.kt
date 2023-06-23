package com.albertojr.proyectoandroidsuperpoderes.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.albertojr.proyectoandroidsuperpoderes.R
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.mappers.GenericToItemCardData

@Composable
fun  ItemCard(elementToDisplay: ItemCardData, onItemCardClicked: (Long)->Unit) {
    ItemCardBase( itemCardData = elementToDisplay, onItemCardClicked)
}

@Composable
private fun ItemCardBase(itemCardData: ItemCardData, onItemCardClicked: (Long)->Unit){
    val width = LocalConfiguration.current.screenWidthDp.dp / 2.5f
    val height = width * 2
    Card(modifier = Modifier
        .background(Color.Transparent)
        .padding(10.dp)
        .clickable {
            onItemCardClicked(itemCardData.id)
            Log.d("Clicked", "Heroe card clicked")
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Box(
            Modifier
                .align(Alignment.CenterHorizontally)
                .background(Color.Red)
                .padding(10.dp)) {
            AsyncImage(model = itemCardData.image, contentDescription = stringResource(id = R.string.character_image) ,
                modifier = Modifier
                    .width(width)
                    .height(height)
                    .clip(RoundedCornerShape(10.dp))
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = size.height / 3,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    },
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )
            Text(text = "${itemCardData.name}",
                modifier = Modifier
                    .width(width)
                    .align(Alignment.BottomCenter),
                color = Color.White,
                overflow = TextOverflow.Clip,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemCard_Preview() {
    val heroe = Heroe(121221,"goku", "Is the best", "url here", false)
    ItemCardBase(GenericToItemCardData().ItemCardMapper(heroe),{})
}