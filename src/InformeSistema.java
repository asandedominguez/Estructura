import java.lang.Runtime;
public class InformeSistema {
    public static int nProcesadores (){
        int procesadores = Runtime.getRuntime().availableProcessors();
        return procesadores;
    }

    public static int mReservada(){

    }

    public static void main (String[] args) {
        System.out.println("PROCESADORES " +
                "\n ---------------- " +
                "\n Disponibles JVM: " + InformeSistema.nProcesadores());
    }
}
