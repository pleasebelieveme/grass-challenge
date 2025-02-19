package com.example.grasschallenge.domain.notificationlog.entity;

import com.example.grasschallenge.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 알림 발송 시각
    @Column(nullable = false)
    private LocalDateTime sentAt;

    // 알림 내용 (선택)
    private String message;

    // 해당 로그와 연결된 멤버
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public NotificationLog(LocalDateTime sentAt, String message, Member member) {
        this.sentAt = sentAt;
        this.message = message;
        this.member = member;
    }
}