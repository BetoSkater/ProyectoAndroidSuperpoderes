package com.albertojr.proyectoandroidsuperpoderes.repository.remote

data class HeroesApiResult (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: HeroesData
)

data class HeroesData (
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<RemoteHeroe> // = HeroeList
)
data class RemoteHeroe (
    val id: Long,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
)