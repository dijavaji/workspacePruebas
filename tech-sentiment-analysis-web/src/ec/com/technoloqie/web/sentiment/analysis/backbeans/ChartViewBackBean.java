package ec.com.technoloqie.web.sentiment.analysis.backbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name="chartViewBackBean")
public class ChartViewBackBean {
	private PieChartModel pieModel1;
    private PieChartModel pieModel2;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Lenin Moreno 1", 39557);
        pieModel1.set("Guillermo Lasso 2", 6401);
        pieModel1.set("Cinthya Viteri 3", 722);
        pieModel1.set("Paco Moncayo 4", 607);
        pieModel1.set("Otros 5", 10);
        pieModel1.setTitle("Que sienten los ecuatorianos sobre los candidatos");
        pieModel1.setLegendPosition("w");
        //pieModel1.setDiameter(300);
        //pieModel1.setSliceMargin(400);
        //pieModel1.setFill(false);
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
         
        pieModel2.set("Brand 1", 540);
        pieModel2.set("Brand 2", 325);
        pieModel2.set("Brand 3", 702);
        pieModel2.set("Brand 4", 421);
         
        pieModel2.setTitle("Custom Pie");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
}
