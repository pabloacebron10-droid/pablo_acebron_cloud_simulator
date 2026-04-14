package simulacion;

public class FogNode {
    private final CloudServer CLOUDSERVER;
    private int alertCount = 0;
    private int contador;

    public FogNode (CloudServer cloudServer, int contador){
        this.CLOUDSERVER = cloudServer;
        this.contador = contador;
    }

    public void processData(SensorData data){
        
        System.out.println("[FOG] Dato recibido: " + data);

        if(data.getTEMPERATURE()>30){
            alertCount++;
            System.out.println("[FOG] ALERTA: temperatura alta");
        } else
            System.out.println("[FOG] Temperatura normal");

            CLOUDSERVER.saveData(data);
    } 


    public int getAlertCount(){
        return alertCount;
    }

    public int getContador() {
        return contador;
    }

}
