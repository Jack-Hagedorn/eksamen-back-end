package facades;

import dtos.DeveloperDTO;
import entities.Developer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class DeveloperFacade {
    private static EntityManagerFactory emf;
    private static DeveloperFacade instance;

    private DeveloperFacade() {
    }

    /**
     * @Param _emf
     * @return the instance of this facade.
     */
    public static DeveloperFacade getInstance(EntityManagerFactory _emf){
        if (instance == null){
            emf = _emf;
            instance = new DeveloperFacade();
        }
        return instance;
    }

    public List<DeveloperDTO> getDevelopers(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Developer> q = em.createQuery("SELECT d FROM Developer d", Developer.class);
            return q.getResultList().stream().map(DeveloperDTO::new).collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    public Developer create(String name, String email, String phone, int billingPrHour){
        EntityManager em = emf.createEntityManager();
        try{
            Developer developer = new Developer(name, email, phone, billingPrHour);
            em.getTransaction().begin();
            em.persist(developer);
            em.getTransaction().commit();

            return developer;
        } finally {
            em.close();
        }
    }
}
