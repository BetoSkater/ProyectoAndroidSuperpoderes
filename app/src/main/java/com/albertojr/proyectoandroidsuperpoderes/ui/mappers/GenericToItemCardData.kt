package com.albertojr.proyectoandroidsuperpoderes.ui.mappers

import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie

class GenericToItemCardData {

    fun <T> ItemCardMapper(elementToDisplay: T): ItemCardData {

        val itemCardData = ItemCardData()
        when (elementToDisplay) {
            is Heroe -> {
                itemCardData.id = elementToDisplay.id
                itemCardData.name = elementToDisplay.name
                itemCardData.image = elementToDisplay.picture
            }
            is Comic -> {
                itemCardData.id = elementToDisplay.id
                itemCardData.name = elementToDisplay.title
                itemCardData.image = elementToDisplay.picture
            }
            is Serie -> {
                itemCardData.id = elementToDisplay.id
                itemCardData.name = elementToDisplay.title
                itemCardData.image = elementToDisplay.picture
            }
            else -> {
                //Default object
            }
        }
        return itemCardData
    }

    fun <T> GenericListToItemCardMapper(elementToTransform: List<T>): List<ItemCardData> {
        var resultList = mutableListOf<ItemCardData>()
        elementToTransform.forEach {
            resultList.add(ItemCardMapper(it))
        }
        return resultList
    }
}