package com.example.homeowners.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreatePersonDto(
  @JsonProperty("first_name")
  val firstName: String,

  @JsonProperty("surname")
  val surname: String
)