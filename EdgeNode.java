package simulacion;

public class EdgeNode {
    private final FogNode fogNode;
    private int contadorEdge;
    private int contadorFog;


    public EdgeNode(FogNode fogNode, int contador, int contadorFog){
        this.fogNode = fogNode;
        this.contadorEdge = contador;
        this.contadorFog = contadorFog;
    }

    public void sendData(int totalReadings){
        for (int i=1;i<=totalReadings;i++){
            if (fogNode.getAlertCount()<20){
                double temperature = 20 + Math.random()*15+1;
                SensorData data = new SensorData("sensor-1", temperature);
                System.out.println("[EDGE]: " + this.getcontadorEdge() + " del [FOG]: " + this.getContadorFog() + " Enviando lectura: "+ i + ": " + data);
                fogNode.processData(data);
                System.out.println();
            }
            else
                break; 
        }
    }

    public int getcontadorEdge() {
        return contadorEdge;
    }
    public int getContadorFog() {
        return contadorFog;
    }

}