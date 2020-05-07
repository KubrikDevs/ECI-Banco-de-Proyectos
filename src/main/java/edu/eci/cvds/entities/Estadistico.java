package edu.eci.cvds.entities;

public class Estadistico {
    private String area;
    private int cantidadDeIniciativas;

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

    @Override
    public String toString() {
        return "Estadistico{" +
                "area='" + area + '\'' +
                ", cantidadDeIniciativas=" + cantidadDeIniciativas +
                '}';
    }
}
