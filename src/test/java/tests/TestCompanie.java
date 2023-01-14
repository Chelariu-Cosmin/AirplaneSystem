package tests;

import entity.Bilete;
import entity.Client;
import entity.Companie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCompanie {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // clear
        em.createQuery("DELETE FROM Companie").executeUpdate();
        em.createQuery("DELETE FROM Bilete ").executeUpdate();
      //  em.createQuery("DELETE FROM Client ").executeUpdate();
        em.getTransaction().commit();

//        Client client = new Client();
//        client.setNume("Bile");
//        client.setAdresa("Adresa");
//        client.setCnp("Cnp");
//        client.setDataNastere(LocalDate.of(2000,12,2));
//        client.setLocalitate("Localitate");
//        client.setTara("Tara");
//        em.persist(client);

        Companie companie = new Companie();
        companie.setNumeCompanie("AIRBNB");
        companie.setPunctaj(2500);
        em.persist(companie);

        List<Bilete> lstBilete = new ArrayList<>();
        lstBilete.add(new Bilete(500.0, "Card"));
        lstBilete.add(new Bilete(500.0, "Card"));
        lstBilete.add(new Bilete(500.0, "Card"));
        companie.setListaBilete(lstBilete);

//        Bilete insertBilete = new Bilete();
//        insertBilete.setPret(524.9);
//        insertBilete.setTipPlata("Card");
//        insertBilete.setCompanie(companie);
//        insertBilete.setClient(client);
//        em.persist(insertBilete);

        // Inainte de persistenta
        System.out.println("Inainte de persistenta");
        printEntitateCompanie(companie);

        // Asociere context persistenta
        em.persist(companie);


        companie.getListaBilete().forEach(m -> em.persist(m));
        System.out.println("Dupa asociere context persistenta");
        printEntitateCompanie(companie);

        // Sincronizare SQL: executie fraze DML-SQL
        em.getTransaction().begin();
        em.flush();
        System.out.println("Dupa Sincronizare SQL: executie fraze DML-SQL");
        printEntitateCompanie(companie);

        // Efectuare transactie
        em.getTransaction().commit();
        System.out.println("Dupa efectuare tranzactie");
        printEntitateCompanie(companie);

        System.out.println("End");

    }

    static void printEntitateCompanie(Companie companie) {
        System.out.println("-------------------------------");
        System.out.println("ID Companie: " + companie.getIdCompanie());
        System.out.println("Bilete companie zbor");
        companie.getListaBilete().stream().forEach(
                m -> System.out.println("    - ID Bilet: " + m.getIdBilet()
                        + ", Pretul biletului: " + m.getPret()));
        System.out.println("-------------------------------");
    }
}
