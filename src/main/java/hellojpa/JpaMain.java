package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        /**
         * EntityManageFactory는 Application 로딩 시점에 딱 하나만 만들어놔야함!!!
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /**
         * (고객의 요청이 있을 때마다) Transaction 할 때마다 EntityManager를 꼭 만들어줘야함
         * EntityManager는 쓰레드 간에 절대 공요를 하면 안됨!! 사용하고 버려야 함!
         */
        EntityManager em = emf.createEntityManager();

        /**
        * JPA의 모든 데이터 변경은 꼭 Transaction 안에서 실행 되여야함!!!!!!
         */
        EntityTransaction tx = em.getTransaction();
        tx.begin();// Database Transaction 을 시작

        try {

/*         회원 등록
            // 비영속 상태 (객체만 생성하고 JPA와는 상관 없는 상태)
           Member member = new Member();
            member.setId(2L);
            member.setName("피자");

            // 영속 상태(엔티티 매니저를 통해 멤버가 관리가 됨) - 이 상태에서는 DB에 쿼리가 날라가는 시점이 아님
            // transaction 커밋하는 시점에 쿼리가 날라감
            em.persist(member); // member를 저장

            // 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
            //em.detach(member);

            // 객체를 삭제한 상태(삭제)
            // em.remove(member);
*/

/*         회원 수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("피영아1");
*/

            /**
             * JPQL
             * JPA를 사용하면 엔티티 객체를 중심으로 개발
             * 검색(쿼리가 필요한 조회)을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색
             * 애플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요
             * JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어를 제공
             * SQL과 문법 유사/ SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 지원
             * JPQL은 엔티티 객체를 대상으로 쿼리 // SQL은 데이터베이스 테이블을 대상으로 쿼리
             */
/*            List<Member> result = em.createQuery("select m from Member as m order by m.id desc ", Member.class)
                    .setFirstResult(0)     // paging 처리를 위한 코드 중 조회 시작 위치
                    .setMaxResults(1)    //  paging 처리를 위한 코드 중  조회 할 데이터 수
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.name = " +  member.getName());
            }*/

/*         회원 삭제
            em.remove(findMember);
*/

/*
            // 영속
            Member member1 = new Member(100L, "A");
            Member member2 = new Member(101L, "B");

            // 이 순간에 영속성 컨텍스트에 엔티티, 쿼리가 쌓이게 됨
            em.persist(member1);
            em.persist(member2);
            System.out.println("=========
*/

/*
            // 영속성 컨텍스트에서 변경 감지(dirty checking 하여 update)
            // JPA는 값을 바꾸면, Transaction Commit 시점에 변경을 반영한다 생각하고 코드 짜기
            Member memberFind = em.find(Member.class, 100L);
            memberFind.setName("ABC");
            System.out.println("=====================");*/

            // 커밋하는 시점에 DB에 쿼리가 날라가게 됨
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }}
