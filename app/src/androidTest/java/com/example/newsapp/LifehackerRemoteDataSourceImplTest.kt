package com.example.newsapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newsapp.data.datasource.LifehackerRemoteDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LifehackerRemoteDataSourceImplTest {

  private lateinit var dataSource: LifehackerRemoteDataSourceImpl

  @Before
  fun setUp() {
    dataSource = LifehackerRemoteDataSourceImpl()
  }

  @Ignore
  @Test
  fun fetchArticleList() = runTest {
    val result = dataSource.fetchContents()
    result.fold(
      onSuccess = {
        it.mapIndexed { index, it ->
          println("Success $index | ${it}")
        }
      },
      onFailure = {
        println("Failure | $it")
      }
    )
  }
}