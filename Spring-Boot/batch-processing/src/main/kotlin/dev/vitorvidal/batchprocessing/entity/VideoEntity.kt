package dev.vitorvidal.batchprocessing.entity

import dev.vitorvidal.batchprocessing.entity.id.VideoId
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "video")
open class VideoEntity {
    @EmbeddedId
    open var id: VideoId? = null

    @Column(name = "video_title")
    open var title: String? = null

    @Column(name = "video_url")
    open var url: String? = null

    @Column(name = "video_duration")
    open var duration: String? = null

    @Column(name = "video_view_count")
    open var viewCount: String? = null

    @Column(name = "video_like_count")
    open var likeCount: String? = null

    constructor()
    constructor(id: VideoId?, title: String?, url: String?, duration: String?, viewCount: String?, likeCount: String?) {
        this.id = id
        this.title = title
        this.url = url
        this.duration = duration
        this.viewCount = viewCount
        this.likeCount = likeCount
    }


    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        other as VideoEntity

        return id != null && id == other.id
    }

    final override fun hashCode(): Int = Objects.hash(id);

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(EmbeddedId = $id )"
    }
}