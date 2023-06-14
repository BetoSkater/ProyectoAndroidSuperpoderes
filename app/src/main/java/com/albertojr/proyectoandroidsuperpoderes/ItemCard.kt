package com.albertojr.proyectoandroidsuperpoderes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap.Companion.Square
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Extension
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Thumbnail

@Composable
fun <T> ItemCard(elementToDisplay:T) {

    val itemCardData = ItemCardData()

    when(elementToDisplay){
        //todo should I create a new object with an enum ty,pe, id , name and picture??
        is Heroe -> {
            itemCardData.id = elementToDisplay.id
            itemCardData.name = elementToDisplay.name
            itemCardData.image = generateImageURLFromThumnail(elementToDisplay.thumbnail)
        }
        is Comic -> {
            itemCardData.id = elementToDisplay.id
            itemCardData.name = elementToDisplay.title
            itemCardData.image = generateImageURLFromThumnail(elementToDisplay.thumbnail)
        }
        is Serie -> {
            itemCardData.id = elementToDisplay.id
            itemCardData.name = elementToDisplay.title
            itemCardData.image = generateImageURLFromThumnail(elementToDisplay.thumbnail)
        }
        else -> {
            //TODO add Something went wrong or whatever
        }
    }
    ItemCardBase( itemCardData = itemCardData)
}


@Composable
private fun ItemCardBase(itemCardData: ItemCardData){
    Card() {
        Box() {
            //TODO Change to AsyncImage and add Coil
            AsyncImage(model = itemCardData.image, contentDescription = "Cool" ,
                modifier = Modifier.drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height/3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient,blendMode = BlendMode.Multiply)
                    }
                }
            )
            Text(text = "${itemCardData.name}",
                modifier = Modifier.align(Alignment.BottomCenter),
                color = Color.White
            )
            //TODO add functionality visible for the favourite heroe list
        }
    }
}
//TODO move to utils, or unpack the image in the repository
private fun generateImageURLFromThumnail(thumbnail: Thumbnail):String{
return "${thumbnail.path}/portrait_uncanny.${thumbnail.extension}"
}



@Preview(showBackground = true)
@Composable
private fun ItemCard_Preview() {
    val heroe = Heroe(121221,"goku", "Is the best", "", Thumbnail("R.drawable.ic_launcher_background",Extension.jpg))
    ItemCard(heroe)
}