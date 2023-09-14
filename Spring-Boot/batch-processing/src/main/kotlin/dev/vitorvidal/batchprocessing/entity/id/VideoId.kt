package dev.vitorvidal.batchprocessing.entity.id

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.proxy.HibernateProxy
import java.util.*

@Embeddable
open class VideoId {
    @Column(name = "video_id")
    open var videoId: String? = null

    @Column(name = "upload_date")
    open var uploadDate: String? = null

    constructor()
    constructor(videoId: String?, uploadDate: String?) {
        this.videoId = videoId
        this.uploadDate = uploadDate
    }


    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass = if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass = if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as VideoId

        return videoId == other.videoId
                && uploadDate == other.uploadDate
    }

    final override fun hashCode(): Int = Objects.hash(videoId, uploadDate);

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(videoId = $videoId , uploadDate = $uploadDate )"
    }
}