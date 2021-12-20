
import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author João
 */
public class TestePersistencia {
    public static void main(String[] args){
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("HospitalModeloPU");
        EntityManager em = enf.createEntityManager();
        Especialidade e = new Especialidade();
        e.setDescricao("PRIMEIRA");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        enf.close();
    }
}
