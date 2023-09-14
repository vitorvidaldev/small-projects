package dev.vitorvidal.batchprocessing.utils

import dev.vitorvidal.batchprocessing.entity.VideoEntity
import dev.vitorvidal.batchprocessing.entity.id.VideoId

class EntityMapper {
    fun mapToEntity(data: String): VideoEntity {
        return VideoEntity(
            id = VideoId(
                videoId = "0",
                uploadDate = data.substring(0, 25)
            ),
            title = data.substring(26, 94).trim(),
            url = data.substring(94, 136).trim(),
            duration = data.substring(137, 145).trim(),
            viewCount = data.substring(145, 157).trim(),
            likeCount = data.substring(157, 161).trim()
        )
    }
}