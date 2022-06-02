package com.kotlin.hbnt.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "tag")
class Tag(
    @Id
    var id: Long? = null,

    var name: String? = null
)
