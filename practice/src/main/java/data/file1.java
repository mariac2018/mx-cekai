package data;

/**
 * @author mixuan.chen
 * @date 2020/11/5
 * @content 登录
 */
public class file1 {
    public Integer miles;
    public String color;
    public Integer size;

    public file1(){
        //构造方法
        //开辟空间
        //把空间的首地址给this  this=0FX00
    }

    public file1(String color, Integer miles){
        this.color=color;
        this.miles=miles;
    }

    public file1(String color, Integer miles, Integer size){
        this(color,miles);
        this.size=size;
    }

    public void setMiles(Integer miles){
        this.miles=miles;  //this表示占位符，指向当前对象的首地址
    }

    public void setColor(String color){
        this.color=color;
    }

    public Integer getMiles(){
        return miles;
    }

    public String getColor(){
        return color;
    }
}
