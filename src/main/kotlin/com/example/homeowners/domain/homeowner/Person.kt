package com.example.homeowners.domain.homeowner

import com.example.homeowners.domain.AbstractEntity
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table

@Table(name = "person")
data class Person(
  var firstName: String,

  var surname: String,

  @MappedCollection(idColumn = "person_id", keyColumn = "id")
  var houses: MutableList<House> = mutableListOf()
) : AbstractEntity()