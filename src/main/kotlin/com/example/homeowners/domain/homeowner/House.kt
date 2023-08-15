package com.example.homeowners.domain.homeowner

import com.example.homeowners.domain.AbstractValueObject
import jakarta.persistence.*

@Entity(name = "house")
@Table(name = "house")
data class House(
  @ManyToOne
  var person: Person?,

  @Column(name = "street_address", nullable = false, insertable = true, updatable = false)
  var streetAddress: String,

  @Column(name = "suburb", nullable = false, insertable = true, updatable = false)
  var suburb: String,

  @Column(name = "postcode", nullable = false, insertable = true, updatable = false)
  var postcode: String
): AbstractValueObject()