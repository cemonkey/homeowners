package com.example.homeowners.converter

import com.example.homeowners.domain.homeowner.Person
import com.example.homeowners.dto.GetPersonDto
import org.springframework.stereotype.Component

@Component
class PersonConverterImpl : PersonConverter {

  override fun toGetPersonDto(source: Person): GetPersonDto {
    return GetPersonDto(
      name = source.firstName,
      surname = source.surname,
      houses = source.houses.map { house ->
        GetPersonDto.House(
          streetAddress = house.streetAddress,
          suburb = house.suburb,
          postcode = house.postcode
        )
      }.toList()
    )
  }
}