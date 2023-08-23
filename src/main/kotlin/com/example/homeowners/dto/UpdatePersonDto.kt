package com.example.homeowners.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdatePersonDto(
  @JsonProperty("first_name")
  val firstName: String,

  @JsonProperty("surname")
  val surname: String
)
