package com.example.homeowners.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PutHousesForPersonDto(
  @JsonProperty("houses")
  val houses: List<HouseDto>
)