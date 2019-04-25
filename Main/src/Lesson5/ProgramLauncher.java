package Lesson5;

import static Lesson5.Methods.methodOne;
import static Lesson5.Methods.methodTwo;


public class ProgramLauncher {

    public static void main(String[] args) {


        new Thread(() -> methodOne()).start();
        new Thread(() -> methodTwo()).start();

    }


}