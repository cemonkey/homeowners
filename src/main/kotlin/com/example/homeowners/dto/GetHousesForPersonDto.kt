package com.example.homeowners.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GetHousesForPersonDto(
  @JsonProperty("houses")
  val houses: List<HouseDto>
)
