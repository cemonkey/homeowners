package com.example.homeowners.dto

import com.fasterxml.jackson.annotation.JsonProperty

class HouseDto(
  @JsonProperty("street_address")
  val streetAddress: String,

  @JsonProperty("suburb")
  val suburb: String,

  @JsonProperty("postcode")
  val postcode: String
)