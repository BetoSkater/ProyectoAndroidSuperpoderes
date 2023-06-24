package com.albertojr.proyectoandroidsuperpoderes.ui.viewModel

import com.albertojr.proyectoandroidsuperpoderes.fakes.FakeLocalDataSource
import com.albertojr.proyectoandroidsuperpoderes.mock.BaseNetworkMockTest
import com.albertojr.proyectoandroidsuperpoderes.repository.DefaultRepository
import com.albertojr.proyectoandroidsuperpoderes.repository.Heroe
import com.albertojr.proyectoandroidsuperpoderes.repository.local.LocalDataSource
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.DefaultRemoteDataSource
import com.albertojr.proyectoandroidsuperpoderes.repository.remote.RemoteDataSource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest

import org.junit.Test


class HeroeListViewModelTest : BaseNetworkMockTest(){
     //SUT -> Repository
     private lateinit var defaultRepository: DefaultRepository

     //Repository dependencies:
     private lateinit var remoteDataSource: RemoteDataSource
     private lateinit var localDataSource: LocalDataSource

    @Test
    fun `WHEN retrieveHeroes() successful Expect heroe list with values`() = runTest{
        //Given
        remoteDataSource = mockk()
        localDataSource = FakeLocalDataSource()
        defaultRepository = DefaultRepository(remoteDataSource, localDataSource)
        val actual = mutableListOf<List<Heroe>>()
        //When

        val collectJob = launch(UnconfinedTestDispatcher(testScheduler)){
           var result = defaultRepository.retrieveHeroes()
            //THEN
            assert((result.size == 5))
        }
        collectJob.cancel()
    }
    @Test
    fun `WHEN heroe liked successful Expect retrieve heroe list to evaluate the change`() = runTest{
        //Given
        remoteDataSource = mockk()
        localDataSource = FakeLocalDataSource()
        defaultRepository = DefaultRepository(remoteDataSource, localDataSource)
        //When
        val heroeId: Long = 1
        val heroeFav = true
        val collectJob = launch(UnconfinedTestDispatcher(testScheduler)){
           defaultRepository.updateHeroeFavStateLocal(heroeId, heroeFav)
            var result = (localDataSource as FakeLocalDataSource).getHeroesAfterLikeCall(heroeId,heroeFav)
            val index = result.indexOfFirst { it.id == heroeId  }

            //THEN
            assert(result[index].isFavourite)
        }
        collectJob.cancel()
    }

    @Test
    fun `WHEN getHeroe() successful Expect heroe  with id != -1`() = runTest{
        //Given
        remoteDataSource = mockk()
        localDataSource = FakeLocalDataSource()
        defaultRepository = DefaultRepository(remoteDataSource, localDataSource)
        val actual = mutableListOf<List<Heroe>>()
        //When
        val invalidId : Long = -1

        val collectJob = launch(UnconfinedTestDispatcher(testScheduler)){
            var result = defaultRepository.retrieveHeroeById(1)
            //THEN
            assert((result.id != invalidId))
        }
        collectJob.cancel()
    }

    @Test
    fun `WHEN retrieveHeroes() successful Expect remote heroe list with values`() = runTest{
        //TODO: Fix, this test yields a positive result when it should not pass, both assert works at the same time
        //Given
        remoteDataSource = DefaultRemoteDataSource(api)
        localDataSource = mockk()
        defaultRepository = DefaultRepository(remoteDataSource, localDataSource)
        val actual = mutableListOf<List<Heroe>>()
        //When
        coEvery { localDataSource.getHeroes() } returns emptyList()
        val collectJob = launch(UnconfinedTestDispatcher(testScheduler)){
            var result = defaultRepository.retrieveHeroes()
            //THEN
            assert((result.size == 20))
          //  assert((result.size == 5))
        }
        collectJob.cancel()
    }
 }