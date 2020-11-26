package string;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {
//        String s="RLLLLRRRLR";
//        String s2="RRLRLRLRLL";
//        int i=balancedStringSplit(s);
//        System.out.println("i = " + i);
        int[] i=new int[4];
        mergeArrayList();
        Set<Integer> set1=Sets.newHashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set set2=Sets.newHashSet();
        set2.add(2);
        set2.add(1);
        set2.add(5);

        Sets.SetView<Integer> set=Sets.union(set1,set2);
        Set<Integer> set3=set.immutableCopy();
        System.out.println("set = " + set);

        Sets.SetView<Integer> set6=Sets.difference(set1,set2);
        System.out.println("set6 = " + set6);

    }

    public static int balancedStringSplit(String s) {
        //每次都从字符串中截取前面的最小的平衡字符串
        char[] chars=s.toCharArray();
        int lCount=0;
        int rCount=0;
        int num=0;
        for(int i=0;i<s.length();i++){
            if(chars[i]=='L'){
                lCount++;
            }
            if(chars[i]=='R'){
                rCount++;
            }
            //当L和R数量相同时，平衡字符串数++
            if((lCount==rCount)){
                num++;
            }
        }

        return num;
    }

    //集合A和B 把A和b中重复的元素去除掉以后合并在一起
    public static void mergeArrayList(){
        List<String> a= Lists.newArrayList("hello","pangzi","xiaobi","happy");
        List<String> b= Lists.newArrayList("hello","xiaomige","nihao","nihao");

        HashSet<String> c= Sets.newHashSet();
        c.addAll(a);
        c.addAll(b);

        System.out.println("c = " + c);

    }
}
