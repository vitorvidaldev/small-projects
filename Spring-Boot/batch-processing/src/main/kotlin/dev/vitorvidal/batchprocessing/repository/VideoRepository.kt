package dev.vitorvidal.batchprocessing.repository

import dev.vitorvidal.batchprocessing.entity.VideoEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class VideoRepository(
    @Autowired
    val jdbcTemplate: JdbcTemplate
) {
    fun persistVideoData(videoEntities: List<VideoEntity>) {
        val sql = "INSERT INTO video (video_id, upload_date, video_title, video_url, video_duration, video_view_count, video_like_count) VALUES (?, ?, ?, ?, ?, ?, ?)"
        val batchPreparedStatement: BatchPreparedStatementSetter = object : BatchPreparedStatementSetter {
            override fun setValues(ps: java.sql.PreparedStatement, i: Int) {
                val videoEntity = videoEntities[i]
                ps.setString(1, videoEntity.id?.videoId)
                ps.setString(2, videoEntity.id?.uploadDate)
                ps.setString(3, videoEntity.title)
                ps.setString(4, videoEntity.url)
                ps.setString(5, videoEntity.duration)
                ps.setString(6, videoEntity.viewCount)
                ps.setString(7, videoEntity.likeCount)
            }

            override fun getBatchSize(): Int {
                return videoEntities.size
            }
        }
        jdbcTemplate.batchUpdate(sql, batchPreparedStatement)
    }

    fun updateVideoData(videoEntities: List<VideoEntity>) {
        val sql = "UPDATE video SET video_view_count = ?, video_like_count = ? WHERE video_id = ? AND upload_date = ?"
        val batchPreparedStatement: BatchPreparedStatementSetter = object : BatchPreparedStatementSetter {
            override fun setValues(ps: java.sql.PreparedStatement, i: Int) {
                val videoEntity = videoEntities[i]
                ps.setString(1, videoEntity.viewCount)
                ps.setString(2, videoEntity.likeCount)
                ps.setString(3, videoEntity.id?.videoId)
                ps.setString(4, videoEntity.id?.uploadDate)
            }

            override fun getBatchSize(): Int {
                return videoEntities.size
            }
        }
        jdbcTemplate.batchUpdate(sql, batchPreparedStatement)
    }
}