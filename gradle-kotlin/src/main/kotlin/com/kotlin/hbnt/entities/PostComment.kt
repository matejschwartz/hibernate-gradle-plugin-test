package com.kotlin.hbnt.entities

import javax.persistence.*


@Entity
@Table(name = "post_comment")
class PostComment(
    @Id
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    var post: Post? = null,

    var review: String? = null
)

