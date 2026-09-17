import java.lang.Runtime;
public class InformeSistema {
    public static int nProcesadores (){
        int procesadores = Runtime.getRuntime().availableProcessors();
        return procesadores;
    }

    public static long mTotal() {
        long total = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        return total;
    }

    public static long mLibre(){
        long libre = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        return libre;
    }

    public static long max() {
        long maximo = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        return maximo;
    }

    public static long mUso() {
        long uso = mTotal() - mLibre() / (1024 * 1024);
        return uso;
    }

    public static long mPorcentaje() {
        long uso = mUso();
        long total = mTotal();
        long porcentaje = (uso * 100) / total;
        return porcentaje;
    }

    public static void main (String[] args) {
        System.out.println("PROCESADORES " +
                "\n =========================== " +
                "\n Disponibles JVM: " + InformeSistema.nProcesadores() +
                "\n (Son hilos lógicos: Con SMT no coinciden con los núcleos físicos)" +
                "\n \n MEMORIA  ANTES" +
                "\n ===========================" +
                "\n Total reservada " + InformeSistema.mTotal() +
                "\n Libre: " + InformeSistema.mLibre() +
                "\n En uso: " + InformeSistema.mUso() + " (" + mPorcentaje() + " % de la total)" +
                "\n Máxima (-Xmx): " + InformeSistema.max() +
                "\n \n MEMORIA DESPUÉS DE RESERVAR 64 MIB"
        );

    }
}
