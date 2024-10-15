package org.brandon.entity;

import jakarta.persistence.*;

public class MedicoListener {

    @PrePersist
    public void prePersist(Medico medico) {
        System.out.println("Medico a ser persistido: " + medico);
    }

    @PostPersist
    public void postPersist(Medico medico) {
        System.out.println("Medico persistido: " + medico);
    }

    @PreUpdate
    public void preUpdate(Medico medico) {
        System.out.println("Medico a ser actualizado: " + medico);
    }

    @PostUpdate
    public void postUpdate(Medico medico) {
        System.out.println("Medico actualizado: " + medico);
    }

    @PreRemove
    public void preRemove(Medico medico) {
        System.out.println("Medico a ser eliminado: " + medico);
    }

    @PostRemove
    public void postRemove(Medico medico) {
        System.out.println("Medico eliminada: " + medico);
    }
}
