package Lesson5;


public class Methods {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];


    static void methodOne() {

        for (int i = 0; i < size; i++) arr[i] = 1;

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();

        System.out.println("Время выполнения по первому методу: " + (System.currentTimeMillis() - a));
    }


    static void methodTwo() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < size; i++) arr[i] = 1;


        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


        new Thread(() -> Methods.doCount(a1, 0)).start();
        new Thread(() -> Methods.doCount(a2, h)).start();


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.currentTimeMillis();
        System.out.println("Время выполнения по второму методу: " + (System.currentTimeMillis() - a));
    }

    static void doCount(float[] a, int h) {
        for (int i = 0; i < a.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
