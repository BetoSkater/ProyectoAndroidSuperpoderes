package com.albertojr.proyectoandroidsuperpoderes.repository.remote


data class HeroesApiResult (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)

data class Data (
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

data class Comics (
    val available: Long,
    val collectionURI: String,
    val items: List<ComicsItem>,
    val returned: Long
)

data class ComicsItem (
    val resourceURI: String,
    val name: String
)

data class Stories (
    val available: Long,
    val collectionURI: String,
    val items: List<StoriesItem>,
    val returned: Long
)

data class StoriesItem (
    val resourceURI: String,
    val name: String,
    val type: ItemType
)

enum class ItemType {
    Cover,
    Empty,
    InteriorStory
}

data class Thumbnail (
    val path: String,
    val extension: Extension
)

enum class Extension {
    jpg
}

data class URL (
    val type: URLType,
    val url: String
)

enum class URLType {
    Comiclink,
    Detail,
    Wiki
}
