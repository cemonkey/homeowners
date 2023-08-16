package com.example.homeowners.domain.homeowner

import com.example.homeowners.domain.AbstractEntity
import com.example.homeowners.domain.Auditable
import jakarta.persistence.*

@Entity(name = "person")
@Table(name = "person")
data class Person(
  @Column(name = "first_name", nullable = false, insertable = true, updatable = true)
  var firstName: String,

  @Column(name = "surname", nullable = false, insertable = true, updatable = true)
  var surname: String,

  @Embedded
  var auditable: Auditable = Auditable()
) : AbstractEntity() {

  @Suppress("SetterBackingFieldAssignment")
  // We cascade all operations to ensure JPA keeps the child in sync with the parent in the datebase
  // The actual operations that need a cascade are: CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE
  // We enable orphan removal so that JPA removes detached children from the database
  @OneToMany(mappedBy = "person", cascade = [CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE], orphanRemoval = true)
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