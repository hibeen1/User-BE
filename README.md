# User-BE

## only for 동욱

### http://localhost:8080/users

1. 회원 가입
  POST /
  
2. 회원 정보
  GET /{userId}
  
3. 아이디 중복체크
  GET /check-id/{userId}
  
4. 닉네임 중복체크
  GET /check-nickname/{nickname}
  
5. 회원 정보 수정
  PUT /{userId}
  
6. 회원 탈퇴
  DELETE /{userId}
