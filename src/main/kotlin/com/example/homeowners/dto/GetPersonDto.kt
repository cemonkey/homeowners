package com.example.homeowners.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GetPersonDto(
  val id: String,
  val name: String,
  val surname: String,
  val houses: List<HouseDto>
)
