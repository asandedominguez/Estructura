import java.io.File;
import java.lang.Runtime;
import java.util.*;

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

    public static String sSeparador() {
        String separador = System.getProperty("file.separator");
        return separador;
    }

    public static String Rruta() {
        String ruta = System.getProperty("user.home");
        return ruta + sSeparador() + "psp" + sSeparador() + "informe.txt" ;

    }

    public static void pPrefijo(String[] pre) {
        String[] prefijos;
        if (pre.length <= 0) {
            prefijos = new String[]{"os.", "user.", "java.version"};
        } else {
            prefijos = pre;
        }
        Properties propiedades = System.getProperties();
        Set<String> nombres = propiedades.stringPropertyNames();
        List<String> resultado = new java.util.ArrayList<>();
        for (String nombre : nombres) {
            for (String prefijo : prefijos) {
                if (nombre.startsWith(prefijo)) {
                    resultado.add(nombre);
                    break;
                }
            }
        }
        resultado.sort(null);
        for (String nombre : resultado) {
            System.out.println(nombre + propiedades.getProperty(nombre));
        }
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
                "===========================" +
                "\n Total reservada " + InformeSistema.actualizaciones() +
                "\n Libre: " + InformeSistema.mLibre() +
                "\n En uso: " + InformeSistema.mUso() + " (" + mPorcentaje() + " % de la total)" +
                "\n Máxima (-Xmx): " + InformeSistema.max() +
                "\n Incremento en uso: " + InformeSistema.actualizaciones() +
                "\n" +
                "\n SISTEMA" +
                "\n  ===========================" +
                "\n os.name: " + InformeSistema.sOperativo() +
                "\n file.separator: " + " '' " + InformeSistema.sSeparador() + " '' " +
                "\n Ruta construida con las propiedades: " +
                "\n " + InformeSistema.Rruta() +
                "\n"
        );
        System.out.println("\n PROPIEDADES FILTRADAS Y ORDENADAS");
        System.out.println(" ===========================");
        InformeSistema.pPrefijo(args);

    }
}
