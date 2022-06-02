package com.kotlin.hbnt.entities

import javax.persistence.*

@Entity(name = "Attachment")
@Table(name = "attachment")
class Attachment(
    @Id
    var id: Long? = null,

    var name: String? = null,

    @Enumerated
    @Column(name = "media_type")
    var mediaType: MediaType? = null,

    @Lob
    @Basic(fetch = FetchType.LAZY)
    var content: ByteArray? = null
)
