package com.example.homeowners.domain.homeowner

import com.example.homeowners.domain.AbstractEntity
import jakarta.persistence.*
import kotlin.jvm.Transient

@Entity(name = "person")
@Table(name = "person")
data class Person(
  @Column(name = "first_name", nullable = false, insertable = false, updatable = false)
  var firstName: String,

  @Column(name = "surname", nullable = false, insertable = false, updatable = false)
  var surname: String,
) : AbstractEntity() {

  @Suppress("SetterBackingFieldAssignment")
  @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
  var houses: MutableList<House> = mutableListOf()
    set(value) {
      // Sever the child's link to the parent
      field.forEach {
        it.person = null
      }

      // Sever the parent's link with the children
      field.clear()

      // Associate the new children with the parent
      value.forEach {
        // Link the child to the parent
        it.person = this

        // Link the parent to the child
        field.add(it)
      }
    }
}