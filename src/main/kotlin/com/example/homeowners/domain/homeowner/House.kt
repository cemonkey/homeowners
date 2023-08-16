package com.example.homeowners.domain.homeowner

import com.example.homeowners.domain.AbstractValueObject
import org.springframework.data.annotation.PersistenceCreator
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "house")
data class House (
  val streetAddress: String,
  val suburb: String,
  val postcode: String
): AbstractValueObject()