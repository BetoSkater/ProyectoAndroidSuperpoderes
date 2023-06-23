package com.albertojr.proyectoandroidsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.albertojr.proyectoandroidsuperpoderes.repository.local.HeroeDAO
import com.albertojr.proyectoandroidsuperpoderes.repository.local.HeroeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    fun provideHeroeDataBase(@ApplicationContext context: Context) : HeroeDataBase{
        return Room.databaseBuilder(
            context,
            HeroeDataBase::class.java, "heroe-db"
        ).build()
    }

    @Provides
    fun provideDao(db: HeroeDataBase): HeroeDAO{
        return db.heroeDao()
    }
}