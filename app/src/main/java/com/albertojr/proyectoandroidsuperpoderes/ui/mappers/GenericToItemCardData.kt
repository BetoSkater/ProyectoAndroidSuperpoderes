package com.albertojr.proyectoandroidsuperpoderes.ui.mappers

import com.albertojr.proyectoandroidsuperpoderes.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.Thumbnail

class GenericToItemCardData {

    fun <T> ItemCardMapper(elementToDisplay:T) : ItemCardData{

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

        return itemCardData
    }

    private fun generateImageURLFromThumnail(thumbnail: Thumbnail):String{
        return "${thumbnail.path}/portrait_uncanny.${thumbnail.extension}"
    }

}