package app.day01;

/**
 * @author mixuan.chen
 * @date 2020/10/20
 * @content 第一天作业
 */
public class Day01 {
    public static void main(String[] args) {
        int num=parseCalculator("158*312");
        System.out.println(num);
        int [] a=new int[]{45,11,7,1,4,4,3,2,2,8,0,23};
        bubbleSort(a);
    }

    //实现一个可以解析字符串的计算器
    public static int parseCalculator(String str){
        String[] strs=str.split("[+]|-|[*]|/");
        int i=Integer.parseInt(strs[0]);
        int j=Integer.parseInt(strs[1]);
        if(str.contains("+")){
            return i+j;
        }
        else if(str.contains("-")){
            return i-j;
        }
        else if(str.contains("*")){
            return i*j;
        }
        else if(str.contains("/")){
            return i/j;
        }
        else{
            return 0;
        }
    }

    //给一个乱序的数组，基于冒泡排序算法进行排序
    public static void bubbleSort(int[] a){
        for(int i=0,temp=0;i<a.length;i++){
            for(int j=a.length-1;j>i;j--){
                if(a[j]<a[j-1]){
                    temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
    }

}

