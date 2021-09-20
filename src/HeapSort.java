public class HeapSort {
    public static void ColocarElemento(int T[], int i, int longitud) {
        int dere, izq, mayor, aux;
        boolean sigue = true;
        izq = 2 * i;
        dere = 2 * i + 1;
        while ((i <= longitud) && sigue) {
// Compruebo si alguno de los hijos tiene un valor
// mayor que el de la pos i.
            if ((izq <= longitud) && (T[izq] > T[i]))
                mayor = izq;
            else
                mayor = i;
            if ((dere <= longitud) && (T[dere] > T[mayor]))
                mayor = dere;
            if (mayor == i)
                sigue = false;
            else {
                aux = T[mayor];
                T[mayor] = T[i];
                T[i] = aux;
                i = mayor;
// calculo de Nuevo el hijo izquierdo y derecho
                izq = 2 * i;
                dere = 2 * i + 1;
            }
        }
    }
    public static void Construir_Monticulo(int T[]) {
        int mitad, i, longitud = T.length;
        mitad = longitud / 2;
        for (i = mitad; i >= 1; i--)
            ColocarElemento(T, i, longitud);
    }
    public static void heap(int T[]) {
        int aux, i;
        int longitud = T.length;
        Construir_Monticulo(T);
        for (i = longitud ; i >= 2; i--) {
            aux = T[i];
            T[i] = T[1];
            T[1] = aux;
            ColocarElemento(T, 1, i);
        }
    }
}