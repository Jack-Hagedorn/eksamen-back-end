package facades;

import dtos.DeveloperDTO;
import entities.Developer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
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

    public DeveloperDTO getDeveloper(String name){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Developer> q = em.createQuery("SELECT d FROM Developer d WHERE d.name =:name", Developer.class);
            q.setParameter("name", name);
            return new DeveloperDTO(q.getSingleResult());
        } catch (NoResultException e){
            throw new WebApplicationException("No developer with that name found" + name, 404);
        } finally {
            em.close();
        }
    }

    public DeveloperDTO addDeveloper(String name, String email, String phone, int billingPrHour){
        EntityManager em = emf.createEntityManager();
        try{
            Developer developer = new Developer(name, email, phone, billingPrHour);
            em.getTransaction().begin();
            em.persist(developer);
            em.getTransaction().commit();

            return new DeveloperDTO(developer);
        } finally {
            em.close();
        }
    }
}
