package simulacion;

import java.util.ArrayList;
import java.util.List;

public class CloudServer {

    private final List<SensorData> dataList = new ArrayList<>();

    public void saveData( List<SensorData> dataListFog){
       for ( SensorData elemento: dataListFog) {
        dataList.add(elemento);
       }
       System.out.println("[CLOUD] Datos guardados: "+ dataList);
    }
        
    

    public void showData(){
        double sum = 0;
        double average = sum /dataList.size();

        System.out.println("\n[CLOUD] Historial de datos:");
        if(dataList.isEmpty()){
            System.out.println("No hay datos guardados");
            return;
        }

        for(SensorData data: dataList){
            System.out.println(data);
            sum += data.getTEMPERATURE();
        }
        
        System.out.println("Media de temperatura: "+ String.format("%.2f", average));
    }
}