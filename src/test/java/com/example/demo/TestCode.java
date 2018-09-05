package com.example.demo;
import org.junit.Test;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;
/**
 * Created by fengjinman Administrator on 2018/8/27.
 */
public class TestCode {

    @Test
    public void test66(){
        String skuprice = "2500.00";
        DecimalFormat d = new DecimalFormat("0.00");
        String format = d.format(Double.parseDouble(skuprice));
        System.out.println(format);
    }
    @Test
    public void test1(){
        List list1 = new ArrayList<>();
        list1.add("fengjinman");
        list1.add("wangzhizhi");
        list1.add("hujinpeng");
        list1.add("lvyumei");
        System.out.println("---------------------");
        System.out.println(list1);
        List list2 = new ArrayList();
        list2.addAll(list1);
        System.out.println(list2);
        System.out.println("---------------------");
        list2.remove(1);
        System.out.println(list1);
        System.out.println(list2);
    }
    @Test
    public void test2(){
        String[] arr = new String[]{"AA","BB","CC"};
        Stream<String> stream1 = Arrays.stream(arr);
        Object[] objects = stream1.toArray();
        for(int i =0;i<objects.length;i++){
            Object object = objects[i];
            System.out.println(object);
        }
    }
    @Test
    public void test3(){
        Date date1 = new Date();
        Date date2 = new Date(1535354996843L);
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
    }
    @Test
    public void test4(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusDays(1L);
        String s = localDateTime.toString();
        System.out.println(s);
        System.out.println(localDateTime1.toString());
    }
    @Test
    public void test5(){
        String s = null;
        Optional<String> s1 = Optional.ofNullable(s);
        String s2 = s1.orElse(new String("zhuzhuangmangxieqingshengma"));
        System.out.println(s2.toCharArray().length);
    }
}