package com.example.homeowners.converter

import com.example.homeowners.domain.homeowner.Person
import com.example.homeowners.dto.GetPersonDto

interface PersonConverter {
  fun toGetPersonDto(source: Person): GetPersonDto

}
