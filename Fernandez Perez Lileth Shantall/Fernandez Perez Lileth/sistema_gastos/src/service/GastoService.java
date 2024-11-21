package service;

import model.Gasto;
import repository.GastoRepository;

import java.util.List;

public class GastoService {

    private final GastoRepository repository;

    public GastoService(GastoRepository repository) {
        this.repository = repository;
    }

    public void agregarGasto(Gasto gasto) {
        if (gasto.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        if (!esCategoriaValida(gasto.getCategoria())) {
            throw new IllegalArgumentException("La categoría no es válida.");
        }
        repository.save(gasto);
    }

    public List<Gasto> obtenerTodosLosGastos() {
        return repository.findAll();
    }

    public void editarGasto(Gasto gasto) {
        if (gasto.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        if (!esCategoriaValida(gasto.getCategoria())) {
            throw new IllegalArgumentException("La categoría no es válida.");
        }
        repository.update(gasto);
    }

    public void eliminarGasto(int id) {
        repository.delete(id);
    }

    private boolean esCategoriaValida(String categoria) {
        return categoria.equals("Alimentación") || categoria.equals("Transporte")
                || categoria.equals("Entretenimiento") || categoria.equals("Salud")
                || categoria.equals("Otros");
    }

    public double obtenerTotalMensual() {
        return repository.obtenerTotalMensual();
    }
}
