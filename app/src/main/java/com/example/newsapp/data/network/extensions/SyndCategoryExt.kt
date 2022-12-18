package com.example.newsapp.data.network.extensions

import com.rometools.rome.feed.synd.SyndCategory

fun <R> SyndCategory.valueOrNull(block: SyndCategory.() -> R): R? {
  return try {
    block()
  } catch (e: Exception) {
    null
  }
}