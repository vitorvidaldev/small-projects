package dev.vitorvidal.batchprocessing

import dev.vitorvidal.batchprocessing.entity.VideoEntity
import dev.vitorvidal.batchprocessing.repository.VideoRepository
import dev.vitorvidal.batchprocessing.utils.EntityMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BatchProcessingApplication : CommandLineRunner {
    @Autowired
    lateinit var videoRepository: VideoRepository

    override fun run(vararg args: String?) {
        val videoData: MutableList<String> = mutableListOf(
            "2023-09-11-12.00.00.000000Mist and Whimsy | Critical Role | Campaign 3, Episode 71            https://www.youtube.com/watch?v=gV68IKU2k7804:17:51192855 views6500",
            "2023-09-07-12.00.00.000000Arcanum Tech Skills & Schematics                                    https://www.youtube.com/watch?v=kC7StCQZW7Y00:11:46004165 views0400",
            "2023-09-04-12.00.00.000000The Mighty Nein vs. Vokodo | Critical Role | Campaign 2, Episode 141https://www.youtube.com/watch?v=Q4wTnjD0jLw04:17:51192855 views6500",
            "2023-09-01-12.00.00.000000Lucien and the Tombtakers | Critical Role | Campaign 2, Episode 140 https://www.youtube.com/watch?v=Q4wTnjD0jLw04:17:51192855 views6500",
            "2023-08-31-12.00.00.000000The Mighty Nein vs. Lucien | Critical Role | Campaign 2, Episode 139https://www.youtube.com/watch?v=Q4wTnjD0jLw04:17:51192855 views6500",
        )

        val videoEntities: List<VideoEntity> = videoData.map { EntityMapper().mapToEntity(it) }
        videoRepository.persistVideoData(videoEntities)

        for (videoEntity in videoEntities) {
            videoEntity.viewCount = "9999"
            videoEntity.likeCount = "9999"
        }

        videoRepository.updateVideoData(videoEntities)
    }
}

fun main(args: Array<String>) {
    runApplication<BatchProcessingApplication>(*args)
}
