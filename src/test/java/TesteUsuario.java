
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
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
public class TesteUsuario {
    public static void main(String[] args){
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("HospitalModeloPU");
        EntityManager em = enf.createEntityManager();
        Usuario u = new Usuario();
        u.setNomeUsuario("joaoAdmin");
        u.setNome("joao");
        u.setSenha("123456");
        u.setEmail("joao@gmail.com");
        u.setAtivo(true);
        u.setDataCadastro(Calendar.getInstance());
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        enf.close();
    }
}
