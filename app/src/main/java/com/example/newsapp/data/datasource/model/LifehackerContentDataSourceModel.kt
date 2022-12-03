package com.example.newsapp.data.datasource.model

import java.util.Date

/**
 * DataSourceが公開するライフハッカーのコンテンツのモデル。
 *
 * @property title コンテンツタイトル。
 * @property description コンテンツの概要。
 * @property link コンテンツのURL。
 * @property categories コンテンツのカテゴリ。
 * @property publishedDate コンテンツの公開日。
 * @property enclosures コンテンツのメディア。
 * @property author 作成者。
 */
data class LifehackerContentDataSourceModel(
  val title: String?,
  val description: String?,
  val link: String?,
  val categories: List<String>,
  val publishedDate: Date?,
  val enclosures: List<String>,
  val author: String?,
)
