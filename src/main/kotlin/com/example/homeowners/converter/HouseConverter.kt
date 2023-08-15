package com.example.homeowners.converter

import com.example.homeowners.domain.homeowner.House
import com.example.homeowners.dto.HouseDto

interface HouseConverter {
  fun toHouseDto(source: House): HouseDto

}
