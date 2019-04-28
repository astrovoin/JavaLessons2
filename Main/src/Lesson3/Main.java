
package Lesson3;

import java.util.ArrayList;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) {

        onetask();            // запуск первого задания (не решено только суммирование нескольких встречающихся слов
        // twotask("Петров");  // запуск второго задания

    }

    private static void twotask(String secondname) {
        PhoneList phoneList = new PhoneList();
        phoneList.addNote("Петр", "Иванов", "123456");
        phoneList.addNote("Саламат", "Зеленый", "162322");
        phoneList.addNote("Женя", "Петров", "123424");
        phoneList.addNote("Захар", "Иванов", "412421");
        phoneList.addNote("Саша", "Измайлов", "154686");
        phoneList.addNote("Иван", "Иванов", "412421");
        phoneList.addNote("Игорь", "Петров", "888888");

        phoneList.getNote(secondname);
    }

    private static void onetask() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Мяч");
        arrayList.add("Стол");
        arrayList.add("Стул");
        arrayList.add("Самолет");
        arrayList.add("Мяч");
        arrayList.add("Кресло");
        arrayList.add("Диван");
        arrayList.add("Стол");
        arrayList.add("Аквариум");
        arrayList.add("Мяч");

        String massArray[] = new String[arrayList.size()];
        arrayList.toArray(massArray);
        HashSet<String> hs = new HashSet<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        // [] = new Integer[arrayList.size()];

        for (int i = 0;  i < massArray.length; i++) {
            hs.add(massArray[i]);
            arrayList2.add(massArray[i].hashCode());

        }
        Integer massArray2[] = new Integer[arrayList2.size()];
        arrayList2.toArray(massArray2);

        System.out.println("Список уникальных слов:");
        System.out.println(hs);
        System.out.println();


   /*     Arrays.sort(massArray);

        int i = 0;
        int ii = 0;
        int count=0;
        int countt = 0;
        while (i < massArray.length) {
            if (i == massArray.length-1) {
               i++;
                break;
            }
            if (massArray[i] == massArray[i+1]) {

                count++;
               i++;
            }
            else i++;
        }

        while (ii < massArray.length) {
            if (ii == massArray.length-1) {
                System.out.println(massArray[ii++]+ " " + countt);
                break;
            }
            if (massArray[ii] == massArray[ii+1]) {
                ii+=2;

                System.out.println(massArray[ii++]+" "+count);
            }
            else System.out.println(massArray[ii++] + " " + count);
        }
*/
    }


}


