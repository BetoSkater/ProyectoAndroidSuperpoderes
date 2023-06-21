package com.albertojr.proyectoandroidsuperpoderes.ui.mappers

import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.repository.Comic
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Serie

class GenericToItemCardData {

    fun <T> ItemCardMapper(elementToDisplay:T) : ItemCardData {

        val itemCardData = ItemCardData()

        when(elementToDisplay){
            //todo should I create a new object with an enum ty,pe, id , name and picture??
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
                //TODO add Something went wrong or whatever
            }
        }

        return itemCardData
    }

    fun <T> GenericListToItemCardMapper(elementToTransform:List<T>) : List<ItemCardData> {

    //   var resultList = List<ItemCardData>(elementToTransform.size)
       var resultList = mutableListOf<ItemCardData>()

        elementToTransform.forEach {
            val itemCardData = ItemCardData()
            when(it){
                //todo should I create a new object with an enum ty,pe, id , name and picture??
                is Heroe -> {
                    itemCardData.id = it.id
                    itemCardData.name = it.name
                    itemCardData.image = it.picture
                }
                is Comic -> {
                    itemCardData.id = it.id
                    itemCardData.name = it.title
                    itemCardData.image = it.picture
                }
                is Serie -> {
                    itemCardData.id = it.id
                    itemCardData.name = it.title
                    itemCardData.image = it.picture
                }
                else -> {
                    //TODO add Something went wrong or whatever
                }
            }
            resultList.add(itemCardData)
        }
        return resultList
    }

}