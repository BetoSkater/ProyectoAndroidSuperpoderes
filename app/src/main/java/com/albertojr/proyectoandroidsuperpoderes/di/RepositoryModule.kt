package com.albertojr.proyectoandroidsuperpoderes.di

import com.albertojr.proyectoandroidsuperpoderes.repository.DefaultRepository
import com.albertojr.proyectoandroidsuperpoderes.repository.Repository
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.DefaultRemoteDataSource
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsRepository(defaultRepository: DefaultRepository): Repository

    @Binds
    abstract fun bindsRemoteDataSource(defaultRemoteDataSource: DefaultRemoteDataSource): RemoteDataSource


}