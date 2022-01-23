#JPA 기본편 study

## 영속성 컨텍스트
<ul># 영속성 컨택스트의 이점
  <li>1차 캐시</li>
  <li>동일성(identity) 보장</li>
  <li>트랜잭션으 지원하는 쓰기 지연(transactional write-behind)</li>
  <li>변경 감지(Dirty Checking)</li>
  <li>지연 로딩(Lazy Loading)</li>
</ul>

## 플러시 - 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영
  <ul>
    <li>영속성 컨텍스트를 비우지 않음</li>
    <li>영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화</li>
    <li>트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면 됨</li>
  </ul>
  <ul></ul>
  <ul># 플러시 발생 시
    <li>변경 감지</li>
    <li>수정되 엔티 쓰기 지연 SQP 저장소에 등록</li>
    <li>쓰기 지연 SQL 저장소의 쿼리르 데이터 베이스에 전송(등록, 수정, 삭제 쿼리)</li>
  </ul>
  <ul></ul>
  <ul># 영속성 컨텍스트를 플러시 하는 방법
    <li>1. em.flush() - 직접 호출</li>
    <li>2. 트랜잭셔 커밋 - 플러시 자동 호출</li>
    <li>3. JPQL 쿼리 실행 - 플러시 자동 호출</li>
  </ul>
  <ul></ul>
  <ul># 준영속 상태로 만드는 방법
    <li>1. em.detach(entity); - 특정 엔티티만 준영속 상태로 전환</li>
    <li>2. em.clear(); - 영속성 컨텍스트를 완전히 초기화</li>
    <li>3. em.close(); - 영속성 컨텍스트를 종료</li>
  </ul>
  
  ## @Entity
  <ul>
    <li>@Entity가 붙은 클래스는 JPA가 관리, 엔티티라 한다.</li>
    <li>JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 필수</li>
  </ul>
  <ul></ul>
  <ul> # 주의
    <li>기본 생성자 필수(파라미터 없는 public or protected 생성자)</li>
    <li>final 클래스, enum, interface, inner 클래스 사용 X</li>
    <li>저장할 필드에 final 사용 X</li>
  </ul>
