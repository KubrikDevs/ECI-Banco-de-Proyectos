package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Estadistico;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosIniciativa;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "estadisticasBean")
@SessionScoped
public class EstadisticasBean extends BasePageBean {
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    ServiciosIniciativa serviciosIniciativa;

    private BarChartModel barChart;

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Estadistico> generarEstadisticas() throws ExcepcionBancoDeProyectos {
        return serviciosIniciativa.buscarEstadisticasPorArea();
    }

    private BarChartModel initBarModel() {
        BarChartModel modelo = new BarChartModel();
        ChartSeries area= new ChartSeries();
        area.setLabel("Numero de iniciativas");
        List<Estadistico> data;
        try {
            data = serviciosIniciativa.buscarEstadisticasPorArea();
            for(Estadistico estadistico : data) {
                area.set(estadistico.getArea(), estadistico.getCantidadDeIniciativas());
            }

            modelo.addSeries(area);
        } catch (ExcepcionBancoDeProyectos e) {
            e.printStackTrace();
        }

        return modelo;
    }


    private void createBarModel(){
        barChart = initBarModel();

        barChart.setTitle("Estadisticas Por Area");
        barChart.setLegendPosition("ne");

        Axis xAxis = barChart.getAxis(AxisType.X);
        xAxis.setLabel("Iniciativas");

        Axis yAxis = barChart.getAxis(AxisType.Y);
        yAxis.setLabel("Area");
        yAxis.setMin(0);
        yAxis.setMax(20);
    }

    public BarChartModel getBarChart(){
        createBarModel();
        return barChart;
    }

}
