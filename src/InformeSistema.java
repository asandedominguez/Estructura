import java.lang.Runtime;
public class InformeSistema {
    public static int nProcesadores (){
        int procesadores = Runtime.getRuntime().availableProcessors();
        return procesadores;
    }

    public static long mTotal() {
        long total = Runtime.getRuntime().totalMemory();
        return total;
    }

    public static long mLibre(){
        long libre = Runtime.getRuntime().freeMemory();
        return libre;
    }

    public static long max() {
        long maximo = Runtime.getRuntime().maxMemory();
        return maximo;
    }

    public static long mUso() {
        long uso = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return uso;
    }

    public static void main (String[] args) {
        System.out.println("PROCESADORES " +
                "\n ---------------- " +
                "\n Disponibles JVM: " + InformeSistema.nProcesadores());

        System.out.println(InformeSistema.mTotal());
    }
}
