package controller;

import model.Gasto;
import service.GastoService;

import java.util.List;

public class GastoController {

    private final GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    public void agregarGasto(String descripcion, String categoria, double monto, String fechaGasto) {
        Gasto gasto = new Gasto(0, descripcion, categoria, monto, fechaGasto);
        service.agregarGasto(gasto);
    }

    public List<Gasto> listarGastos() {
        return service.obtenerTodosLosGastos();
    }

    public void editarGasto(int id, String descripcion, String categoria, double monto, String fechaGasto) {
        Gasto gasto = new Gasto(id, descripcion, categoria, monto, fechaGasto);
        service.editarGasto(gasto);
    }

    public void eliminarGasto(int id) {
        service.eliminarGasto(id);
    }

    public double obtenerTotalMensual() {
        return service.obtenerTotalMensual();
    }
}
