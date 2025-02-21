package com.example.grasschallenge.domain.member.entity;

public enum NotificationStatus {
    NOT_SENT,       // 아직 오늘 알림을 보내지 않은 상태
    SENT            // 오늘 이미 알림을 보낸 상태 (중복 방지)
}
