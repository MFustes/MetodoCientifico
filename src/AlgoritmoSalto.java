public class AlgoritmoSalto {
    public static int salto(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = step;
        while (arr[Math.min(step, n) -1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
        //El numero de nuestra posicion actual es mayor que x. Tenemos que buscar en el salto anterior
        if (step <= arr.length-1 && arr[step]>x){
            prev= step;
        }
        //Al exceder el tamaño de la array, debemos de buscar en el salto anterior
        if(step >= arr.length)
            prev= arr.length-1;
        //Realizamos la busqueda lineal en la array
        while (prev <= arr.length-1 && arr[prev] > x) {
            prev--;
            if (prev == Math.min(step, n))
                return -1;
        }
        if (prev <= arr.length-1 && arr[prev] == x)
            return prev;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,40,60,1231,2000,1244444,200000000};
        for (int i = 0; i <= arr.length-1; i++) {
            System.out.println("Numero: "+i+" en posicion: "+ salto(arr,arr[i]));
        }

    }
}
