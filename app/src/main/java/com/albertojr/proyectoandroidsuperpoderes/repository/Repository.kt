package com.albertojr.proyectoandroidsuperpoderes.repository

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteHeroe

interface Repository {
    suspend fun retrieveHeroes(): List<Heroe>

}