package com.example.newsapp.data.network.extensions

import com.rometools.rome.feed.synd.SyndEntry

fun <R> SyndEntry.valueOrNull(block: SyndEntry.() -> R): R? {
  return try {
    block()
  } catch (e: Exception) {
    null
  }
}