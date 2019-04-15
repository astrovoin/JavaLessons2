public class Main {

    public static void setArray(String[] x, String[] y) {

        String[][] mass = {x, y};


        int[][] massint = new int[x.length][y.length];

        int summ = 0;


        if (x.length == 4 && y.length == 4) {

            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass[i].length; j++) {

                    if (mass[i][j] == "1" || mass[i][j] == "2" || mass[i][j] == "3" || mass[i][j] == "4" || mass[i][j] == "5" || mass[i][j] == "6" || mass[i][j] == "7" || mass[i][j] == "8" || mass[i][j] == "9") {

                        massint[i][j] = Integer.parseInt(mass[i][j]);
                        System.out.print(massint[i][j]);


                        //  summ = massint[i][j] + massint[i][j];
                        //  mass[i][j] = Integer.parseInt(mass[i][j]);
                        //  System.out.println(summ);
                        // catch (MyArrayException e) {
                        //   System.out.println();
                        //  e.myArrayDataException();
                        // System.out.print(massint[i][j]);

                    } else {
                        MyArrayException xe = new MyArrayException();
                        System.out.print(" ");
                        System.out.println("Здесь ошибка преобразования строки в число");
                        //   System.out.println(massint[i][j]);

                        throw xe;
                    }


                }
                System.out.println();
            }
        } else {
            MyArrayException e = new MyArrayException();
            System.out.println("Ошибка длинны массива, введите размер 4х4!");
            throw e;


        }
    }


    public static void main(String args[]) {
// без ошибок
        String[] x = {"1", "2", "3", "4"};
        String[] y = {"5", "6", "7", "8"};
        setArray(x, y);
// ошибка символа
        System.out.println();
        String[] m = {"1", "2", "3", "4"};
        String[] n = {"5", "j", "7", "8"};
        setArray(m, n);
// ошибка размера
        System.out.println();
        String[] xx = {"1", "2", "3"};
        String[] yy = {"5", "6", "7", "8"};
        setArray(xx, yy);
    }
}
