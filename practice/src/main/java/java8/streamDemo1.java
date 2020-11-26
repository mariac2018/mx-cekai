package java8;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class streamDemo1 {
    public static void main(String[] args) {

        List<String> strList= Lists.newArrayList("hello","mc","m","cccc","hhhhh");
        //List<String> strList= parseFile("D:\\work\\code\\mx-cekai\\practice\\src\\main\\java\\data\\file3");
        testCollect(strList);
    }

    public static void testMiddleOper(List<String> strList){
        //普通流
        strList.stream();
        //并行流，数据较多时，并行化处理
        strList.parallelStream();
        //stream的操作：中间操作，返回的还是stream，包括stream<T>和LongStream等,可以再对对Stream进行操作
        //中间操作：filter，参数是Predicate接口
        strList.stream().filter(str->str.length()==5).forEach(str-> System.out.println("str = " + str));
        // map（转化）,参数传递的是Function接口
        strList.stream().map(str->str.toUpperCase()).forEach(str-> System.out.println("str = " + str));
        // sorted(默认ascii排序和compartor方式)
        strList.stream().sorted().forEach(str-> System.out.println("str = " + str));
        //传Compartor接口
        strList.stream().sorted((o1,o2)->Integer.parseInt(o1)-Integer.parseInt(o2)).forEach(str-> System.out.println("str = " + str));
        //这个用法不是很理解？？
        strList.stream().sorted();
        strList.stream().sorted(Comparator.comparingInt(Integer::parseInt)).forEach(str-> System.out.println("str = " + str));
         //limit限制数据返回大小
        strList.stream().limit(1).forEach(str-> System.out.println("limit = " + str));
        // skip跳过几个
        strList.stream().skip(2).limit(2).forEach(str-> System.out.println("skip = " + str));
        //peek输出节点上的数据是啥,返回的是流，参数是consumer
        strList.stream().peek(str-> System.out.println("peek = " + str));
        //FlatMap扁平流：对集合里的集合进行操作（相当于把集合里的集合拆箱，进行处理）？返回的还能是集合的集合吗？
        List list1=Lists.newArrayList("xiaomi1","xiaomi2","xiaomi3");
        List list2=Lists.newArrayList("xiaobi1","xiaobi2","xiaobi3");
        List<List<String>> listAll=new ArrayList();
        listAll.add(list1);
        listAll.add(list2);
        listAll.stream()
                //flatMap里的接口方法，返回的必须是stream
                .flatMap(list->list.stream())
                .map(str->str.toUpperCase())
                .forEach(str->System.out.println("flatMap=="+str));

    }

    private static void testOptional(List<String> strList){
        //结果操作
        //count
        long count=strList.stream()
                .filter(str->str.length()==5)
                .count();
        System.out.println("count = " + count);
        //FindFirst 返回Optional<> java8的特性
        //optional相当于类再做一层包装，主要是处理当数据为null的情况，optional不会等于null,
        //用get可以返回对象，用optional.orElse() 表示当optional的值为empty时，取else里面的数
        Optional<String> optional= strList.stream()
                .limit(1)
                .findFirst();
        System.out.println("optional = " + optional);
        String a;
        //如果为空的话，a的值设为hello
        a=optional.orElse("aaaaa");
        System.out.println("a = " + a);
        if(optional.isPresent()){
            a=optional.get();
            System.out.println("a = " + a);
        }

    }

    private static void testCollect(List<String> strList){
        //Collect ->to set/map
        List<String> aa=strList.stream()
                .filter(str->str.length()>3)
                //.collect(Collectors.toList());
                .collect(Collectors.toList());
        System.out.println("aa = " + aa);

        Set<String> bb=strList.stream()
                .filter(str->str.length()>3)
                //.collect(Collectors.toSet())
                .collect(Collectors.toSet());
        System.out.println("bb = " + bb);

        Map map=strList.stream()
                .filter(str->str.length()>3)
                //toMap里面传入两个接口，第一个为key值，第二个为value值
                .collect(Collectors.toMap(str->str,str->str.length()));
        map.forEach((k,v)->{
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });

        //groupBy ->返回的是map,key是接口返回的值
        Map groupMap=strList.stream()
                .collect(Collectors.groupingBy(str->str.length()));
        groupMap.forEach((k,v)->{
            System.out.println("k group = " + k);
            System.out.println("v group = " + v);
        });
        //partation -->分区，分为两部分，返回map<Boolean,List<>>
        Map partitionMap=strList.stream()
                .collect(Collectors.partitioningBy(str->str.length()==5));

        partitionMap.forEach((k,v)->{
            System.out.println("k partation = " + k);
            System.out.println("v partation = " + v);
        });

        //join 加分隔符，变成string
        String s=strList.stream()
                .collect(Collectors.joining(","));
        System.out.println("s = " + s);
    }

    private static void foo3(List<String> strList){
        //找出全文的单词，转小写，并排序->list里
        List strList2=strList.stream()
                .filter(str->str.matches("[a-zA-Z]+"))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("strList2 = " + strList2);
    }

    //读取文件，转List
    private static List parseFile(String path){
        List<String> list=new ArrayList<>();
        File file=new File(path);
        try(BufferedReader bf=new BufferedReader(new FileReader(file))){
            String len;
            while((len=bf.readLine())!=null){
                String[] arrays= StringUtils.split(len," ");
                List<String> arrList=Lists.newArrayList(arrays);
                list.addAll(arrList);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return list;

    }
}
