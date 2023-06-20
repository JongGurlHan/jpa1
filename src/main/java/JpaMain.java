import jpql.*;

import javax.persistence.*;
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

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername(null);
            member.setAge(10);
            member.setType(MemberType.ADMIN);

            member.changeTeam(team);

            em.persist(member);
            em.flush();
            em.clear();

            String query = "select coalesce(m.username, '이름 없는 회원') from Member m ";

            List<String> resultList = em.createQuery(query, String.class)
                    .getResultList();

            for (String s : resultList) {
                System.out.println("s = " + s);
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
