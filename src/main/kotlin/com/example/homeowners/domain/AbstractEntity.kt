package com.example.homeowners.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*

/**
 * Abstract base class to represent an *Entity* in Domain Driven Design.
 *
 * An *Entity* represents an object that has an id and is mutable.
 *
 * Two entities are equivalent if both have the same id.
 *
 * Since entities can be created, modified and deleted, this implementation supports these operations in the following ways:
 *
 * 1. The implementation contains an immutable *created* field to tell when the entity was created.
 * 2. The implementation contains a *lastUpdated* field to tell when the entity was last updated.
 * 3. The implementation contains a *version* field to support *optimistic locking*. Pessimistic reads and writes can still be performed on this object through targeted repository methods.
 */
@MappedSuperclass
abstract class AbstractEntity(
  @Id
  @Column(length = 36, unique = true, nullable = false)
  var id: String = UUID.randomUUID().toString(),

  @Column(name = "created", nullable = false, insertable = true, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  var created: Date = Date(),

  @Column(name = "last_updated", nullable = false, insertable = true, updatable = true)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  var lastUpdated: Date = Date(),

  @Version
  @Column(name = "version", nullable = false, insertable = true, updatable = true)
  private val version: Int? = null
)