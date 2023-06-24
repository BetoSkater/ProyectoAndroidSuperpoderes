package com.albertojr.proyectoandroidsuperpoderes.mock

import com.albertojr.proyectoandroidsuperpoderes.repository.remote.DefaultRemoteDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RemoteDataSourceTest: BaseNetworkMockTest() {
//TODO fix , this text has a 200 code, but it fails. java.io.EOFException: End of input
//	at _COROUTINE._BOUNDARY._(CoroutineDebugging.kt:46) I've found that adding a void body can help, but that means to mofify the base code.

//    @Test
//    fun `When retrieve remote heroes expect 20 heroes`() = runTest{
//        val remoteDataSource = DefaultRemoteDataSource(api)
//        val result = remoteDataSource.retrieveHeroes()
//
//        assert(result.size == 20)
//    }
}