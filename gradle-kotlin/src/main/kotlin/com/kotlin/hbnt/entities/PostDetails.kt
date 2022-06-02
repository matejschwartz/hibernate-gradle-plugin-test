package com.kotlin.hbnt.entities

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "post_details")
class PostDetails(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(name = "created_on")
    var createdOn: Date? = null,

    @Column(name = "created_by")
    var createdBy: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    var post: Post? = null
)
