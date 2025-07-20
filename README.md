# 🌱 Grass Challenge

스터디원들의 GitHub 커밋 활동(잔디)을 자동으로 체크하고,  
잔디가 심어졌을 경우 Slack으로 알림을 보내주는 시스템입니다.

<br/>

## 📌 목적

- 스터디 멤버들이 매일 커밋하는 습관을 기를 수 있도록 돕습니다.
- 자동으로 GitHub 잔디 상태를 확인하여 Slack에 알림을 전송합니다.
- “지속적인 커밋”을 통해 꾸준한 학습 및 실천을 유도합니다.

<br/>

## ⚙️ 주요 기능

- GitHub Contributions(잔디) 조회
- 잔디가 심어졌는지 매일 저녁 10시 확인
- 커밋 기록 Slack 알림 전송
- 유저별 GitHub ID 및 Slack Webhook 관리
- 잔디 중복 알림 방지

<br/>

## 🧱 기술 스택

| 분야 | 사용 기술 |
|------|-----------|
| 백엔드 | Spring Boot 3.x |
| 스케줄링 | `@Scheduled` |
| 데이터베이스 | Supabase (PostgreSQL) |
| HTTP 요청 | Jsoup (GitHub HTML 파싱) |
| 메시징 | Slack Webhook |
| 배포 | Cloudtype 무료 서버 |

<br/>

## 🗂️ 프로젝트 구조 (예정)
```
grass-challenge/
├── src/
│ ├── main/
│ │ ├── java/com/example/grass/
│ │ │ ├── member/ # 사용자 관련 도메인
│ │ │ ├── scheduler/ # 잔디 체크 스케줄러
│ │ │ ├── github/ # 잔디 조회 서비스
│ │ │ └── slack/ # 슬랙 메시지 서비스
│ └── resources/
│ └── application.yml
├── README.md
├── .env
└── build.gradle
```


<br/>

## 🛠️ 사용법 (예정)

1. Supabase에 유저 테이블 생성
2. GitHub ID 및 Slack Webhook 등록
3. Spring Boot 서버 실행
4. 매일 아침 9시 자동 실행 (잔디 심기 독려)
5. 매일 저녁 9시 자동 실행 (잔디 체크 & 슬랙 알림)

> 초기에는 수동으로 실행해도 OK.  
> 이후 GitHub Actions 또는 Cloudtype을 통해 주기적 실행 가능.

<br/>

## 🙋 참여자

- @kim123 (예시)
- @lee456 (예시)

> 참여자는 GitHub ID 기준으로 Slack Webhook을 함께 등록해 주세요.

<br/>

## 🔒 주의사항

- Supabase 무료 요금제는 요청 수/용량 제한이 있습니다.
- GitHub contributions는 HTML 구조가 변경되면 크롤링이 깨질 수 있습니다.
- Slack Webhook은 외부에 노출되지 않도록 `.env` 혹은 DB에서 관리하세요.

<br/>

## 📃 License
없음
