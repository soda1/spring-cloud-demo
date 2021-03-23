import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test1 {


    @Test
    public void Test() {

        List<Integer> list = Arrays.asList(11, 7, 2, 5, 9, 21,8, 30,10 );
        list = new ArrayList<>(list);

        list.sort((a, b) -> {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        });


        List listA = new ArrayList<Integer>();
        List listB = new ArrayList<Integer>();
        System.out.println(list);

        int sumA = list.get(0);
        int sumB = list.get(1);
        listA.add(list.get(0));
        listB.add(list.get(1));
        list.remove(0);
        list.remove(0);
        System.out.println(list);
        for (Integer integer : list) {
            if (sumB  <= sumA) {
                listB.add(integer);
                sumB += integer;
            }else {
                listA.add(integer);
                sumA += integer;
            }
        }
        System.out.println(sumA);
        System.out.println(sumB);
        System.out.println(listA.toString());
        System.out.println(listB.toString());

    }
}
