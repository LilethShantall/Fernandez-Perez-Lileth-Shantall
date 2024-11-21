package model;

public class Gasto {

    private int id;
    private String descripcion;
    private String categoria;
    private double monto;
    private String fechaGasto;

    // Constructor vacío
    public Gasto() {
    }

    // Constructor completo
    public Gasto(int id, String descripcion, String categoria, double monto, String fechaGasto) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.monto = monto;
        this.fechaGasto = fechaGasto;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(String fechaGasto) {
        this.fechaGasto = fechaGasto;
    }
}
