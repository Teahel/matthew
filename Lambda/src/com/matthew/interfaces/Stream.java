package com.matthew.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew.interfaces
 * @CreateDate: 2019/9/6 18:07
 * @Version: 1.0
 */
public class Stream {
    public static void main(String args[]){
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100));
        apples.add(new Apple(130));
        apples.add(new Apple(600));
        apples.add(new Apple(300));
        apples.add(new Apple(500));
        apples.add(new Apple(300));
        apples.add(new Apple(200));

        List<Apple> appleList = apples.parallelStream().filter((Apple a)->a.getWeight()>200).collect(Collectors.toList());
        appleList.forEach(System.out::println);

       /* List<Apple> appleList1 = apples.stream().filter((Apple a)->a.getWeight()>200).collect(Collectors.toList());
        appleList1.forEach(System.out::println);*/
    }
}
