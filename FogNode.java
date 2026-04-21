package simulacion;

import java.util.ArrayList;
import java.util.List;

public class FogNode {
    private final CloudServer CLOUDSERVER;
    private int alertCount = 0;
    private int contador;
    private List<SensorData> dataListFog = new ArrayList<>();
    private static final int N_MAX_DATOS_GUARDADOS = 5;

    public FogNode (CloudServer cloudServer, int contador){
        this.CLOUDSERVER = cloudServer;
        this.contador = contador;
    }

    public void processData(SensorData data){
        
        System.out.println("[FOG] Dato recibido: " + data);

        if(data.getTEMPERATURE()>30){
            alertCount++;
            System.out.println("[FOG] ALERTA: temperatura alta");
        } else{
            System.out.println("[FOG] Temperatura normal");
        }
            dataListFog.add(data);
            enviar();
    }

    private void enviar() {
        if(dataListFog.size() == N_MAX_DATOS_GUARDADOS){
            CLOUDSERVER.saveData(dataListFog);
            dataListFog.clear();
        }
    } 
        public void finish() {
        if (!dataListFog.isEmpty()) {
            enviar();
        }
    }


    public int getAlertCount(){
        return alertCount;
    }

    public int getContador() {
        return contador;
    }
    public List<SensorData> getDataListFog() {
        return dataListFog;
    }

}
