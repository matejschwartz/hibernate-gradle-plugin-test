package com.kotlin.hbnt.entities

import org.hibernate.annotations.LazyToOne
import org.hibernate.annotations.LazyToOneOption
import javax.persistence.*

@Entity
@Table(name = "post")
class Post(
    @Id
    var id: Long? = null,

    var title: String? = null,

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true)
    var comments: MutableList<PostComment> = mutableListOf(),

    @OneToOne(mappedBy = "post", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    var details: PostDetails? = null,

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "post_tag",
        joinColumns = [JoinColumn(name = "post_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    var tags: List<Tag> = mutableListOf(),
) {
    fun setDetails(details: PostDetails?): Post {
        if (details == null) {
            if (this.details != null) {
                this.details!!.post = null
            }
        } else {
            details.post = this
        }
        this.details = details
        return this
    }

    fun addComment(comment: PostComment): Post {
        comments.add(comment)
        comment.post = this
        return this
    }

    fun removeComment(comment: PostComment): Post {
        comments.remove(comment)
        comment.post = null
        return this
    }
}
