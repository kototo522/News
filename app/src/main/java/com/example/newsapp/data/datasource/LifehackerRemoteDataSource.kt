package com.example.newsapp.data.datasource

import com.example.newsapp.data.datasource.model.LifehackerContentDataSourceModel

/**
 * ライフハッカーのコンテンツをリモートから取得するDataSource。
 */
interface LifehackerRemoteDataSource {

  suspend fun fetchContents(): Result<List<LifehackerContentDataSourceModel>>
}