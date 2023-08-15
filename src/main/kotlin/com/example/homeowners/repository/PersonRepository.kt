package com.example.homeowners.repository

import com.example.homeowners.domain.homeowner.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository: CrudRepository<Person, String>