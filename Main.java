package simulacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLecturas;
        final int TAMAÑO_DEL_ARRAY_FOG = 5;
        final int TAMAÑO_DEL_ARRAY_EDGE = 5;

        CloudServer cloudServer = new CloudServer();

        int contadorFog = 1;

        FogNode [] tablaFogNodes = new FogNode[TAMAÑO_DEL_ARRAY_FOG];
        EdgeNode [] [] tablaEdgeNodes = new EdgeNode[TAMAÑO_DEL_ARRAY_FOG][TAMAÑO_DEL_ARRAY_EDGE];

        while (contadorFog <= TAMAÑO_DEL_ARRAY_FOG) {

            int contadorEdge = 1;

            FogNode fogNode = new FogNode(cloudServer, contadorFog);
            tablaFogNodes[contadorFog -1] = fogNode;

            while (contadorEdge <= TAMAÑO_DEL_ARRAY_EDGE){
                EdgeNode edgeNode = new EdgeNode(fogNode, contadorEdge, contadorFog);
                tablaEdgeNodes[contadorFog - 1] [contadorEdge - 1] = edgeNode;
                contadorEdge ++;
            }
            contadorFog ++;
        }


       

        System.out.println(" ==== SIMULACION CLOUD - FOG - EDGE ====\n ");
        System.out.println("Introduce el número de lecturas de temperatura a realizar: ");
        numLecturas = sc.nextInt();

        for (int i= 0; i<TAMAÑO_DEL_ARRAY_FOG ; i++){
            for (int j = 0; j< TAMAÑO_DEL_ARRAY_EDGE; j++){
                tablaEdgeNodes[i][j].sendData(numLecturas);
            }
        }

        cloudServer.showData();

        for(int z = 0; z < TAMAÑO_DEL_ARRAY_FOG; z++){
            System.out.println("Alertas detectadas en FOG: "+ tablaFogNodes[z].getAlertCount());
        }
        sc.close();
    }
}