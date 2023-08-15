package com.example.homeowners.converter

import com.example.homeowners.domain.homeowner.House
import com.example.homeowners.dto.HouseDto
import org.springframework.stereotype.Component

@Component
class HouseConverterImpl : HouseConverter {
  override fun toHouseDto(source: House): HouseDto {
    return HouseDto(
      streetAddress = source.streetAddress,
      suburb = source.suburb,
      postcode = source.postcode
    )
  }
}