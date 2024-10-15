package org.brandon.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.brandon.entity.Medico;

import java.util.List;

public class MedicoRepository {

    private final EntityManagerFactory emf;

    public MedicoRepository() {

        emf = Persistence.createEntityManagerFactory("medicoPU");
    }

    public void crear(Medico medico) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Medico leer(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public List<Medico> leerTodos() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Medico p", Medico.class)
                    .getResultList();
        }
    }

    public void actualizar(Medico medico) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(medico);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Medico medico = em.find(Medico.class, id);
            if (medico != null) {
                em.remove(medico);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}