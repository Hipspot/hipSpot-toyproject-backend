<p align="center"><img width='200px' src="https://user-images.githubusercontent.com/24623403/193721398-c6bb6f0d-859e-4601-9057-f063bfbb82f5.png"></p>
<p align='center'>
<a href="https://github.com/Endless-Creation-32nd/hipSpot-toyproject-backend/issues"><img src='https://img.shields.io/github/issues/Endless-Creation-32nd/hipSpot-toyproject-backend'></a>
<a href="https://github.com/Endless-Creation-32nd/hipSpot-toyproject-backend/graphs/contributors"><img src='https://img.shields.io/github/contributors/Endless-Creation-32nd/hipSpot-toyproject-backend'></a>
</p>

# TodoList 토이 프로젝트

Hipspot 프로젝트를 진행하기 전 팀원들과 간단히 협업해봅니다.

## Skills

- Spring Boot
- JPA / MySQL

## Mocking Apis

| 종류          | 도메인 | uri             | method | body | response |
| ------------- | ------ | --------------- | ------ | ---- | -------- |
| 투두목록 조회 | Todo   | /todo           | GET    | null | Todo[]   |
| 투두 추가     | Todo   | /todo           | POST   | Todo | Todo     |
| 투두 수정     | Todo   | /todo/:id       | PATCH  | Todo | Todo     |
| 투두 토글     | Todo   | /todo/toggle:id | PATCH  | null | Todo     |
| 투두 삭제     | Todo   | /todo/:id       | DELETE | null | null     |

## Member
<table>
  <tr align="center">
    <td>황인서</td>
    <td>정지원</td>
  </tr>
  <tr>
     <td align="center">
        <a href="https://github.com/sjsjsj1246"><img src="https://avatars.githubusercontent.com/u/24623403?v=4" width="150px" alt="이효린"/><br /></a>
     </td>
     <td align="center">
        <a href="https://github.com/jiwonidooly"><img src="https://avatars.githubusercontent.com/u/101682617?v=4" width="150px" alt="황인서"/><br /></a>
     </td>
  <tr>
</table>