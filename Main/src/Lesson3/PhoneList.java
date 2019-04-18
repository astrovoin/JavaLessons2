
package Lesson3;

import java.util.ArrayList;


public class PhoneList {
    private ArrayList<String> firstname;
    private ArrayList<String> secondname;
    private ArrayList<String> phonenumber;


    public PhoneList() {
        firstname = new ArrayList<>();
        secondname = new ArrayList<>();
        phonenumber = new ArrayList<>();
    }


    public void addNote(String _firstname, String _secondname, String _phonenumber) {

        firstname.add(_firstname);
        firstname.hashCode();
        secondname.add(_secondname);
        secondname.hashCode();
        phonenumber.add(_phonenumber);
        phonenumber.hashCode();
    }

    public void getNote(String _secondname) {
        String a;
        for (int i = 0; i < secondname.size(); i++) {  // перебор всех значений ArrayList
            String t = secondname.get(i);  // получение индекса
            if (t.equalsIgnoreCase(_secondname)) { // проверка на введенное значение _secondname
                //int c = secondname.indexOf(i);
                a = String.valueOf(i); // находит индекс
                int c = Integer.parseInt(a); // преобразует индекс в int
                System.out.println(secondname.get(c)+ " | " + firstname.get(c)+ " | " + phonenumber.get(c)); // выводит информацию по индексу
            }
        }
    }
}
