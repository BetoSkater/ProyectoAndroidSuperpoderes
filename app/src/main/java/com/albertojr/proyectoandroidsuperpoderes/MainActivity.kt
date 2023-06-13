package com.albertojr.proyectoandroidsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.ui.theme.ProyectoAndroidSuperpoderesTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.jar.Attributes.Name


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val heroeListViewModel : HeroeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoAndroidSuperpoderesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    apiTestVM(heroeListViewModel)
                }
            }
        }
    }
}

@Composable
fun apiTestVM(viewModel: HeroeListViewModel, modifier: Modifier = Modifier) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        viewModel.retrieveHeroes("")
    }

    //TODO Qhat does it do? Call the base Composable used by both, the preview and the app
    apiTest(state){ heroe ->

    }
}

@Composable
fun apiTest(heroes: List<Heroe>, onitemClicled: (String)->Unit){
    Column() {
        Text(text = "Heroes List")
        LazyColumn(){
            items(items = heroes, key = {it.id}){heroe ->
                heroeItem(heroe = heroe)
            }
        }
    }
}
@Composable
fun heroeItem(heroe: Heroe){
    Text(text = heroe.name)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoAndroidSuperpoderesTheme {
        apiTest(emptyList(), {})
    }
}
/*
fun getApiKey(): String {
    val fl = rootProject.file("gradle.properties")

    if (fl.exists()) {
        val properties = Properties()
        properties.load(FileInputStream(fl))
        return properties.getProperty("prueba")
    } else {
        throw FileNotFoundException()
    }
}

Properties properties = new Properties()
        if (project.rootProject.file('local.properties').canRead()) {
            properties.load(project.rootProject.file("local.properties").newDataInputStream())
        }


        buildConfigField 'String', 'HASH', properties.getProperty('HASH', '"xxxxxxxxx"')
        buildConfigField 'String', 'api_key', properties.getProperty('api_key', '"xxxxxxxx"')
        buildConfigField 'String', 'TS', properties.getProperty('TS', '"0"')

 */