package com.example.newsapp.data.network.extensions

import com.rometools.rome.feed.synd.SyndEnclosure

fun <R> SyndEnclosure.valueOrNull(block: SyndEnclosure.() -> R): R? {
  return try {
    block()
  } catch (e: Exception) {
    null
  }
}