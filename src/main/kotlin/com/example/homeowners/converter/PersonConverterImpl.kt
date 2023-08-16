package com.example.homeowners.converter

import com.example.homeowners.domain.homeowner.Person
import com.example.homeowners.dto.GetPersonDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class PersonConverterImpl(
  private val houseConverter: HouseConverter
) : PersonConverter {

  override fun toGetPersonDto(source: Person): GetPersonDto {
    return GetPersonDto(
      id = source.id,
      name = source.firstName,
      surname = source.surname,
      houses = source.houses.map {
        houseConverter.toHouseDto(it) }.toList()
    )
  }
}