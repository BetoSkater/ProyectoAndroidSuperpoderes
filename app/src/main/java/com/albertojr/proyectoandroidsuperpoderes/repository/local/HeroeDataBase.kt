package com.albertojr.proyectoandroidsuperpoderes.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albertojr.proyectoandroidsuperpoderes.repository.local.models.HeroeLocal

@Database(entities = [HeroeLocal::class], version = 1)
abstract class HeroeDataBase : RoomDatabase(){
    abstract fun heroeDao():HeroeDAO
}