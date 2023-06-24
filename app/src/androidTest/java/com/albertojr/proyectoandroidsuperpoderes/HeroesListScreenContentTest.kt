package com.albertojr.proyectoandroidsuperpoderes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import com.albertojr.proyectoandroidsuperpoderes.repository.DefaultRepository
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.Repository
import com.albertojr.proyectoandroidsuperpoderes.repository.local.LocalDataSource
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteDataSource
import com.albertojr.proyectoandroidsuperpoderes.ui.components.CustomTopBar
import com.albertojr.proyectoandroidsuperpoderes.ui.model.ItemCardData
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroeDetailScreen
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroeDetailScreenContent
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroesListScreen
import com.albertojr.proyectoandroidsuperpoderes.ui.scaffolds.HeroesListScreenContent
import com.albertojr.proyectoandroidsuperpoderes.ui.viewModel.HeroeListViewModel
import org.junit.Rule
import org.junit.Test

class HeroesListScreenContentTest {
    @get:Rule
    val composeRule = createComposeRule()

//Test to check if AppTopBars variants are displayed correctlly.
    @Test
    fun check_if_heroe_list_top_bar_has_basic_top_bar_version_1(){
        //Given
        composeRule.setContent {
        HeroesListScreenContent(listOf(
            Heroe(1, "Goku", "Descripción de Goku", "https://gokupicture.jp", false),
            Heroe(2, "Vegeta", "Descripción de Vegeta", "https://vegetapicture.jp", false)
        ),{})
        }
        //When-Then
        composeRule.onNodeWithTag("basic_top_bar").assertExists()
    }

    @Test
    fun check_if_heroe_list_top_bar_has_basic_top_bar_version_2(){
       //Given
        with(composeRule){
            setContent {
                HeroesListScreenContent(listOf(
                    Heroe(1, "Goku", "Descripción de Goku", "https://gokupicture.jp", false),
                    Heroe(2, "Vegeta", "Descripción de Vegeta", "https://vegetapicture.jp", false)
                ),{})
            }
        //When-Then
            onNodeWithTag("basic_top_bar").assertExists().assertIsEnabled()
        }
    }

    //Scroll list
    @Test
    fun check_if_heroe_list_scrool_work(){
        //Given
        with(composeRule){
            setContent {
                HeroesListScreenContent(listOf(
                    Heroe(1, "Goku1", "Descripción de Goku", "https://gokupicture.jp", false),
                    Heroe(2, "Goku2", "Descripción de Vegeta", "https://vegetapicture.jp", false),
                    Heroe(3, "Goku3", "Descripción de Goku", "https://gokupicture.jp", false),
                    Heroe(4, "Goku4", "Descripción de Vegeta", "https://vegetapicture.jp", false),
                    Heroe(5, "Goku5", "Descripción de Goku", "https://gokupicture.jp", false),
                    Heroe(6, "Goku6", "Descripción de Vegeta", "https://vegetapicture.jp", false),
                ),{})
            }
            //When-Then
            Thread.sleep(1000)
            onNodeWithTag("heroe_list_lazy_column").performScrollToIndex(5)
            Thread.sleep(1000)
        }
    }
}
