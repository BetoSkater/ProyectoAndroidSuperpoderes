package com.albertojr.proyectoandroidsuperpoderes.repository.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroeLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name= "name" ) val name: String,
    @ColumnInfo(name= "description" ) val description: String,
//    @ColumnInfo(name= "modified" ) val modified: String,
    @ColumnInfo(name= "photo" ) val photo: String,
    @ColumnInfo(name= "isFavourite" ) val isFavourite: Boolean = false
)
//@Entity(tableName = "heroes")
//data class HeroeLocal(
//    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
//    @ColumnInfo(name= "name" ) val name: String,
//    @ColumnInfo(name= "description" ) val description: String,
//    @ColumnInfo(name= "modified" ) val modified: String,
//    @ColumnInfo(name= "photoId" ) val photoId: String,
//    @ColumnInfo(name= "isFavourite" ) val isFavourite: Boolean = false
//)
