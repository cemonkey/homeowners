package com.example.homeowners.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
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
 *
 */
abstract class AbstractEntity(
  @Id
  var id: String = UUID.randomUUID().toString(),

  @CreatedDate
  var created: Date = Date(),

  @LastModifiedDate
  var lastUpdated: Date = Date(),

  @Version
  var version: Int? = null
)