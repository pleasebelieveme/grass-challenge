package com.example.grasschallenge.domain.member.entity;

import com.example.grasschallenge.common.BaseEntity;
import com.example.grasschallenge.domain.commitlog.entity.CommitLog;
import com.example.grasschallenge.domain.notificationlog.entity.NotificationLog;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Slack에서 받아온 고유 사용자 ID (슬랙 내에서 유일한 값)
    @Column(nullable = false, unique = true)
    private String slackId;

    // 슬랙에 표시되는 닉네임 (사용자 구분 용이)
    @Column(nullable = false)
    private String nickname;

    // GitHub username (잔디 확인 및 커밋 추적용)
    @Column(nullable = false, unique = true)
    private String githubUsername;

    // (선택) 자동 커밋을 위한 GitHub Personal Access Token
    private String githubToken;

    // 마지막 커밋 시각 (잔디 심은 최신 시간 기록)
    private LocalDateTime lastCommitAt;

    // 유저 상태 (잔디 알림 중복 방지 등 상태 관리용)
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;

    // CommitLog와의 1:N 관계 (멤버가 여러 커밋 기록을 가질 수 있음)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommitLog> commitLogs = new ArrayList<>();

    // NotificationLog와의 1:N 관계 (멤버가 여러 알림 기록을 가질 수 있음)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotificationLog> notificationLogs = new ArrayList<>();

    @Builder
    public Member(String slackId, String nickname, String githubUsername, String githubToken, LocalDateTime lastCommitAt, NotificationStatus notificationStatus, List<CommitLog> commitLogs, List<NotificationLog> notificationLogs) {
        this.slackId = slackId;
        this.nickname = nickname;
        this.githubUsername = githubUsername;
        this.githubToken = githubToken;
        this.lastCommitAt = lastCommitAt;
        this.notificationStatus = notificationStatus;
        this.commitLogs = commitLogs;
        this.notificationLogs = notificationLogs;
    }

    public void updateLastCommitAt(LocalDateTime time) {
        this.lastCommitAt = time;
    }

}