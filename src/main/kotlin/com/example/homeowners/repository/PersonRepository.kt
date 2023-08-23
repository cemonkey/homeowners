package com.example.homeowners.repository

import com.example.homeowners.domain.homeowner.Person
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PersonRepository: CrudRepository<Person, String> {

  // Unfortunately, we have to use the Java Optional here as we are overriding the existing repository method
  @Cacheable(cacheNames = ["personsById"], key = "#id")
  override fun findById(id: String): Optional<Person>

  @CachePut(cacheNames = ["personsById"], key = "#entity.id")
  override fun <S : Person> save(entity: S): S
}