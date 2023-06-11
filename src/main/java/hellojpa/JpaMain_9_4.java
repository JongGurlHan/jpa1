package hellojpa;

import hellojpa.domain.Address;
import hellojpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_9_4 {
    public static void main(String[] args) {

        int a  = 10;
        int b  = 10;

        System.out.println("(a == b) = " + (a == b));

        Address address1 = new Address("city", "street", "1000");
        Address address2 = new Address("city", "street", "1000");

        System.out.println("(address1 == address2) = " + (address1 == address2));

        System.out.println("address1 equals address2 = " + (address1.equals(address2)));

        
    }

}
