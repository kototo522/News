package com.example.newsapp.data.datasource

import com.example.newsapp.data.datasource.model.LifehackerContentDataSourceModel
import com.example.newsapp.data.network.HttpClientProvider
import com.example.newsapp.data.network.RssProvider
import com.example.newsapp.data.network.extensions.valueOrNull
import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.utils.io.jvm.javaio.toInputStream

class LifehackerRemoteDataSourceImpl(
  private val client: HttpClient = HttpClientProvider.getInstance(),
) : LifehackerRemoteDataSource {

  override suspend fun fetchContents(): Result<List<LifehackerContentDataSourceModel>> {
    return runCatching {
      val response: HttpResponse = client.get(RssProvider.Lifehacker)
      val xmlReader = XmlReader(response.bodyAsChannel().toInputStream())
      val feed = SyndFeedInput().build(xmlReader)

      feed.entries.mapNotNull { entity ->
        entity.toLifehackerContentDataSourceModel()
      }
    }
  }

  private fun SyndEntry.toLifehackerContentDataSourceModel(): LifehackerContentDataSourceModel? {
    return try {
      LifehackerContentDataSourceModel(
        title = valueOrNull { title },
        description = valueOrNull { description.value },
        link = valueOrNull { link },
        categories = categories.mapNotNull { it.valueOrNull { name } },
        publishedDate = valueOrNull { publishedDate },
        enclosures = enclosures.mapNotNull { it.valueOrNull { url } },
        author = valueOrNull { author },
      )
    } catch (e: Exception) {
      null
    }
  }
}