package K2dz5;

public class main {
    public static void main(String[] args) throws InterruptedException {
        StartApp();
        ArraysCopy();
    }

    public static void StartApp(){
        final int size = 10000000;
        float[] arr = new float[size];
        long a = System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void ArraysCopy() throws InterruptedException {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread tr = new Thread(() ->{
            long a = System.currentTimeMillis();
            for (int i = 0; i <a1.length ; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println(System.currentTimeMillis() - a);
        });

        Thread tr1 = new Thread(()->{
            long a = System.currentTimeMillis();
            for (int i = 0; i <a2.length ; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println(System.currentTimeMillis() - a);
        });
        tr.start();
        tr1.start();
        tr.join();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }
}
