package com.albertojr.proyectoandroidsuperpoderes.repository.remote.models

data class ComicRemote (
    val id: Long,
    val digitalId: Long,
    val title: String,
    val issueNumber: Long,
    val variantDescription: String,
    val description: String? = null,
    val modified: String,
    val isbn: String,
    val upc: String,
    val diamondCode: String,
    val issn: String,
    val pageCount: Long,
    val dates: List<Date>,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val images: List<Thumbnail>,
)

data class Date (
    val type: DateType,
    val date: String
)

enum class DateType {
    digitalPurchaseDate,
    focDate,
    onsaleDate,
    unlimitedDate
}

enum class Format {
    Comic,
    hardcover,
    TradePaperback
}

data class Price (
    val type: PriceType,
    val price: Double
)

enum class PriceType {
    digitalPurchasePrice,
    printPrice
}