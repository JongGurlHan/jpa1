package hellojpa;

import hellojpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //EntityManagerFactory는 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //db작업 단위마다 EntityManager 만든다. 쓰레드간에 공유x(사용하고 버려야한다.)
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            Member findMember = em.find(Member.class, 1L);
           // findMember.setName("HelloJPA");

            //수정할 때 em.persist안해도 된다!
            //jpa는 트렌젝션 커밋하는 시점에 변경이됐는지 체크한다.
            //변경이 감지되면 알아서 update쿼리 날려준다.

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    //.setFirstResult(5) 갯수 지정
                    //.setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
           //     System.out.println("member.name = " + member.getName());
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
