# Request Vacation API Server
Request Vacation API Server는 휴가 요청을 관리하도록 설계되었습니다.

## Function Specification
- User model과 Login System이 필요합니다. 단, Sign Up 기능은 필요하지 않습니다.
- Users 에게 매년 15일의 연차가 부여됩니다.
- Users 는 매년 연차/반차(0.5일)/반반차(0.25일)에 해당하는 휴가를 신청할 수 있습니다.
- 휴가 신청시 시작일, 종료일(반차/반반차의 경우는 필요없음), 사용 일수, 코멘트(선택 항목)를 입력합니다. 
  - 휴가 신청시 남은 연차를 표시합니다. 
  - 연차를 모두 사용한 경우 휴가를 신청할 수 없습니다. 
  - 추가 기능: 사용 일수를 입력하는 대신 시작일, 종료일을 가지고 공휴일을 제외하고 계산해도 됩니다. 
- 아직 시작하지 않은 휴가는 취소할 수 있습니다.

## How to Run
```
./gradlew bootrun

# Using IntelliJ #
1. Sync gradle
2. Run Application
```
## API Endpoints
### Authentication
- POST /api/login: 사용자가 로그인하고 인증 토큰을 받도록 허용.
```http request
POST /api/login

payload: {
  username (string),
  passowrd (string)
}

```
### Vacations
- POST /api/vacation/request: 해당하는 휴가 조건에 의해 휴가 요청을 생성.
```http request
POST /api/vacation/request

payload {
  vacationType (string),
  startDate (date),
  endDate (date),
  comment (string)
}
```
- GET /api/vacation/{user_id}: 특정 User가 휴가를 요청한 목록 검색. 
- GET /api/vacation: 모든 휴가 요청 목록을 검색.
- GET /api/vacation/{vacation_id}: 특정 휴가 요청의 세부 정보를 검색.
- PUT /api/vacation/{vacation_id}: 특정 휴가 요청의 세부 정보를 업데이트.
- DELETE /api/vacation/{vacation_id}: 특정 휴가 요청 취소.

## Call Sequence Example
Example: Cancel Vacation

1. [POST /api/login]: Authenticate user가 Login API 호출
2. [GET /]: Home View 호출
3. [GET /api/vacation/request]: Vacation 요청하는 View 호출
4. [GET /]: Home View 호출
5. [GET /api/vacation/detail]: 특정 유저의 Vacation을 조회하는 View 호출
6. [DELETE /api/vacation/{vacation_id}]: 특정 Vacation을 취소하는 API 호출
7. [GET /]: Home View 호출

## Technologies Used
API 서버는 Java Spring Boot를 사용하여 구축되었으며 데이터의 영구 저장을 위해 DBMS를 사용합니다.

- OpenJDK 17 
- Spring Boot 3.0.2
- Gradle 7.6
- Spring Data JPA
- Spring Security
- Thymeleaf
- Lombok
- MySQL
- H2 Hibernate 

## Entity
TODO: 엔티티 그림
TODO: 연차/반차(0.5일)/반반차(0.25일) 타입별로 연차 일수 계산
TODO: 휴가 신청시 시작일, 종료일(반차/반반차의 경우는 필요없음) - 반차 반반차의 경우 이그노어
TODO: 아직 시작하지 않은 휴가는 취소할 수 있습니다. (PENDING 또는 APPROVED이고), REQ_CANCEL이 아니고, REQ_CANCEL이 아니고, USED가 아니면
TODO: 스케줄드로 APPROVED 베케이션 끌어와서, 현재 날짜이거나, 현재 날짜보다 오늘이 작으면 USED


## Database Schema
API 서버에 사용되는 데이터베이스 스키마는 아래와 같습니다.

```vbnet
users
- user_id (integer, primary key)
- password (string)
- user_name (string)
- role (string)
- available_vac_days (float)
- requested_vac_days (float)
- created_at (date)
- updated_at (date)


vacations
- vacation_id (integer, primary key)
- user_id (integer, foreign key)
- vacation_type (string)
- status (string)
- days_used (float)
- start_date (date)
- end_date (date)
- comment (string)
- created_at (date)
- updated_at (date)
```

