package com.example.homeowners.controller

import com.example.homeowners.converter.HouseConverter
import com.example.homeowners.converter.PersonConverter
import com.example.homeowners.domain.homeowner.House
import com.example.homeowners.dto.GetHousesForPersonDto
import com.example.homeowners.dto.GetPersonDto
import com.example.homeowners.dto.PutHousesForPersonDto
import com.example.homeowners.repository.PersonRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/persons")
class PersonController(
  private val personRepository: PersonRepository,
  private val personConverter: PersonConverter,
  private val houseConverter: HouseConverter
) {
  @GetMapping
  fun getAllPersons(): List<GetPersonDto> {
    return personRepository.findAll()
      .map { personConverter.toGetPersonDto(it) }
      .toList();
  }

  @GetMapping("/{personId}")
  fun getPersonById(
    @PathVariable(name = "personId")
    personId: String
  ): GetPersonDto {
    val person = personRepository.findById(personId)
      .orElseThrow()
    return personConverter.toGetPersonDto(person)
  }

  @GetMapping("/{personId}/houses")
  fun getHousesForPerson(
    @PathVariable(name = "personId")
    personId: String
  ): GetHousesForPersonDto {
    val person = personRepository.findById(personId)
      .orElseThrow()
    return GetHousesForPersonDto(
      houses = person.houses.map { houseConverter.toHouseDto(it) }
    )
  }

  @PutMapping("/{personId}/houses")
  fun putHousesForPerson(
    @PathVariable(name = "personId")
    personId: String,

    @RequestBody
    body: PutHousesForPersonDto
  ) {
    val person = personRepository.findById(personId)
      .orElseThrow()

    // Set the houses to the new values
    person.houses = body.houses.map {
      House(
        person = null,
        streetAddress = it.streetAddress,
        suburb = it.suburb,
        postcode = it.postcode
      )
    }.toMutableList()

    personRepository.save(person)
  }
}