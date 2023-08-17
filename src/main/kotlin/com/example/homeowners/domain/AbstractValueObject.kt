package com.example.homeowners.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceCreator
import java.util.*

/**
 * Abstract base class that represents a *Value Object* in Domain Driven Design (DDD).
 *
 * A *Value Object* is an object that is defined by the values it contains.
 *
 * Two Value Objects are equivalent if all values in the objects are equivalent.
 *
 * From a DDD perspective a *Value Object* does not contain an id,
 * but this implementation contains a private id field to make the mapping of Value Objects
 * to database tables easier.
 *
 *
 * Since Value Objects are immutable, they can only ever be created or deleted, never modified.
 * This has the following effects on this implementation:
 *
 * 1. The implementation contains an immutable *created* field to tell when the entity was created.
 * 2. This implementation does not contain a *lastUpdated* field.
 * 3. This implementation does not implement *Persistable* as the persistence framework never needs
 * to tell if the object is new because Value Objects are always linked (and persisted) via a parent Entity.
 * 4. This implementation contains no *version* field as it is never updated via optimistic locking,
 * and the persistence framework never needs to tell if the object is new because Value Objects are
 * always linked (and persisted) via a parent Entity.
 *
 */
abstract class AbstractValueObject(
  @Id
  private var id: String = UUID.randomUUID().toString(),
) {
  // We unfortunately have to make every field in this class a var as Spring-data-jdbc uses the setter to set this value when retrieving from the database
  // There are two alternatives:
  // 1. We make a flat data class and have no inheritance for Value Objects. Every data class must explicitly define the id and created fields
  //    This means more boilerplate in every value object we make
  // 2. We make this a val, but provide a secondary constructor in the derived class and use @PersistenceCreator to tell Spring-data-jdbc to use constructor based instantiation.
  //    This means an extra constructor in every class, and every field must be available in the primary constructor :(
  @CreatedDate
  var created: Date = Date()
    private set
}