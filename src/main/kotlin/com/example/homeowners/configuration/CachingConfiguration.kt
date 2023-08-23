package com.example.homeowners.configuration

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableCaching
class CachingConfiguration {

  @Bean
  fun cacheManager(): CacheManager {
    val cacheManager = SimpleCacheManager()

    val personsBySurnameCache = ConcurrentMapCache("personsById")

    cacheManager.setCaches(mutableListOf(personsBySurnameCache))
    return cacheManager
  }
}