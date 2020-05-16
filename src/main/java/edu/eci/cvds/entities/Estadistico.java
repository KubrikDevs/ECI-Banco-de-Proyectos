package edu.eci.cvds.entities;

public class Estadistico {
    private String area;
    private EstadoIniciativa estado;
    private int cantidadDeIniciativas;

    public Estadistico(){

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCantidadDeIniciativas() {
        return cantidadDeIniciativas;
    }

    public void setCantidadDeIniciativas(int cantidadDeIniciativas) {
        this.cantidadDeIniciativas = cantidadDeIniciativas;
    }

    public EstadoIniciativa getEstado() {
        return estado;
    }

    public void setEstado(EstadoIniciativa estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estadistico{" +
                "area='" + area + '\'' +
                ", cantidadDeIniciativas=" + cantidadDeIniciativas +
                '}';
    }
}
