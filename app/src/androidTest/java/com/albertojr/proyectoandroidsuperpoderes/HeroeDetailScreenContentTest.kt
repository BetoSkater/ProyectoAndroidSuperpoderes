package com.albertojr.proyectoandroidsuperpoderes

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroeDetailScreenContent
import org.junit.Rule
import org.junit.Test

class HeroeDetailScreenContentTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun check_if_detail_view_top_bar_has_basic_top_bar_version_1(){
        //Given
        val heroe = Heroe(1, "Goku", "Descripción de Goku", "https://gokupicture.jp", false)
        val comicsList = listOf<ItemCardData>( ItemCardData(1,"First Comic", "Image"))
        val seriesList = listOf<ItemCardData>( ItemCardData(1,"First Serie", "Image"))
        composeRule.setContent {
            HeroeDetailScreenContent(heroe, comicsList, seriesList, true, {},{})
        }
        //When-Then
        composeRule.onNodeWithTag("extended_top_bar").assertExists()
    }

    //Detail view bottom app bar
    @Test
    fun check_if_detail_view_bottom_bar_floatting_buttom_is_clickable(){
        //Given
        val heroe = Heroe(1, "Goku", "Descripción de Goku", "https://gokupicture.jp", false)
        val comicsList = listOf<ItemCardData>( ItemCardData(1,"First Comic", "Image"))
        val seriesList = listOf<ItemCardData>( ItemCardData(1,"First Serie", "Image"))
        composeRule.setContent {
            HeroeDetailScreenContent(heroe, comicsList, seriesList, false, {}){
                true
            }
        }
        //When-Then
        composeRule.onNodeWithTag("fav_button").performClick()
        Thread.sleep(1000)
    }

    @Test
    fun check_if_detail_view_tab_row_works(){
        //Given
        val heroe = Heroe(1, "Goku", "Descripción de Goku", "https://gokupicture.jp", false)
        val comicsList = listOf<ItemCardData>( ItemCardData(1,"First Comic", "Image"))
        val seriesList = listOf<ItemCardData>( ItemCardData(1,"First Serie", "Image"))
        composeRule.setContent {
            HeroeDetailScreenContent(heroe, comicsList, seriesList, false, {}){
                true
            }
        }
        //When-Then
        Thread.sleep(1000)
        composeRule.onNodeWithTag("detail_tab_row").performClick()
        Thread.sleep(1000)
        composeRule.onNodeWithTag("detail_tab_row").assertExists()
        Thread.sleep(1000)
    }
}