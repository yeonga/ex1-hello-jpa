package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
           Member member = new Member();
            member.setId(2L);
            member.setName("피자");
            em.persist(member); // member를 저장
*/

            Member findMember = em.find(Member.class, 1L);
            findMember.setName("피영아1");

/*         회원 삭제
            em.remove(findMember);
*/
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }}
