public class MyArrayException  extends RuntimeException{

    public void myArraySizeException  ()
    {
        System.out.println("Ошибка длинны массива, введите размер 4х4");
    }

    public void myArrayDataException  ()
    {
        System.out.println("Ошибка преобразования строки в число");

    }
}
