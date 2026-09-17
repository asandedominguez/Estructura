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
        long usoBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return usoBytes / (1024 * 1024);
    }

    public static long mPorcentaje() {
        long uso = mUso();
        long total = mTotal();
        long porcentaje = (uso * 100) / total;
        return porcentaje;
    }

    public static long actualizaciones() {
        long uso = mUso();

        long[] reservado = new long[8 * 1024 * 1024];
        if (reservado.length > 0) {
            reservado[0] = 1;
        }

        long usoFinal = mUso();
        return usoFinal - uso;
    }

    public static String sOperativo() {
        String sistema = System.getProperty("os.name");
        return sistema;
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
                "\n \n MEMORIA DESPUÉS DE RESERVAR 64 MIB" + "\n " +
                "\n Total reservada " + InformeSistema.actualizaciones() +
                "\n Libre: " + InformeSistema.mLibre() +
                "\n En uso: " + InformeSistema.mUso() + " (" + mPorcentaje() + " % de la total)" +
                "\n Máxima (-Xmx): " + InformeSistema.max() +
                "\n" + InformeSistema.sOperativo()
        );

    }
}
