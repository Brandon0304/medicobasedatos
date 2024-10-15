package org.brandon.service;

import org.brandon.entity.Medico;
import org.brandon.repository.MedicoRepository;

import java.util.List;

public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService() {
        this.repository = new MedicoRepository();
    }

    public void crearMedico(Medico medico) {
        repository.crear(medico);
    }

    public Medico obtenerMedico(Long id) {
        return repository.leer(id);
    }

    public List<Medico> obtenerTodosLosMedicos() {
        return repository.leerTodos();
    }

    public void actualizarMedico(Medico medico) {
        repository.actualizar(medico);
    }

    public void eliminarMedico(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
