package app.day02;

import java.util.*;

/**
 * @author mixuan.chen
 * @date 2020/10/29
 * @content 第二次作业
 */
public class Day02 {
    public static void main(String[] args) {
        List<String> commonData1=compareStrings();
        List<Integer> commonData2=compareIntegers();
        System.out.println(commonData1);
        System.out.println(commonData2);

        HashSet<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(6);
        set1.add(4);
        set1.add(3);
        sortHashSet(set1);
    }

    public static List<String> compareStrings(){
        String[] array1={"aa","bb","cc"};
        List<String> list1= Arrays.asList(array1);
        String[] array2={"ee","cc","dd","cc"};
        List<String> list2=Arrays.asList(array2);
        List<String> commonDatas=duplicatedData(list1,list2);
        return commonDatas;
    }

    public static List<Integer> compareIntegers(){
        Integer[] array1={1,2,3,4,5,6,7};
        List<Integer> list1= Arrays.asList(array1);
        Integer[] array2={5,8,5};
        List<Integer> list2=Arrays.asList(array2);
        List<Integer> commonDatas=duplicatedData(list1,list2);
        return commonDatas;
    }

    //判断两个集合是否有相同元素，若有则输出相同的元素
    public static <K> List<K> duplicatedData(List<K> list1, List<K> list2){
        List commonDatas=new ArrayList();
        for(K k:list1){
            if(list2.contains(k)){
                if(commonDatas.contains(k)){
                    continue;
                }
                else{
                    commonDatas.add(k);
                }
            }
        }
        return commonDatas;
    }

    //给定一个HashSet，倒序其中元素，输出
    public static void sortHashSet(HashSet<Integer> sets){
        TreeSet<Integer> treeSet=new TreeSet(new MyComparator());
        treeSet.addAll(sets);
        System.out.println(treeSet);
    }

   private static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            return o2-o1;
        }
    }
}


