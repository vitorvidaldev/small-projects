package dev.vitorvidal.threads.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ThreadEntity {
    @JsonProperty("thread_id")
    private UUID threadId;
    @JsonProperty("thread_content")
    private String threadContent;

    private LikeEntity numberOfLikes;

    private ViewEntity numberOfViews;

    private AccountEntity account;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
