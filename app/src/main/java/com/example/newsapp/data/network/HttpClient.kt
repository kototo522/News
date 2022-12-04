package com.example.newsapp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.xml.xml

object HttpClientProvider {

  private var instance: HttpClient? = null

  fun getInstance(): HttpClient {
    return instance ?: synchronized(this) {
      val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
          xml()
        }
      }
      instance = client
      client
    }
  }
}