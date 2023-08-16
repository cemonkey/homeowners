package com.example.homeowners.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*


@Embeddable
data class Auditable(
  @Column(name = "created", nullable = false, insertable = true, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  var created: Date = Date(),

  @Column(name = "last_updated", nullable = false, insertable = true, updatable = true)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  var lastUpdated: Date = Date(),
)