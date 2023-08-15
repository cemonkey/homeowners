package com.example.homeowners.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.domain.Persistable
import java.util.*
import kotlin.jvm.Transient

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
 * 3. This implementation uses a *version* field to tell if the value object has been persisted. The optimistic locking support is a redundant side effect.
 * We do not implement Persistable here as that requires a public id on the object.
 *
 */
@MappedSuperclass
abstract class AbstractValueObject(
  @Id
  @Column(length = 36, unique = true, nullable = false)
  private var id: String = UUID.randomUUID().toString(),

  @Column(name = "created", nullable = false, insertable = true, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  val created: Date = Date(),

  @Version
  @Column(name = "version", nullable = false, insertable = true, updatable = true)
  var version: Int? = null
)