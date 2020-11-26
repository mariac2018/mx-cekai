package oob;

/**
 * @author mixuan.chen
 * @date 2020/11/5
 * @content 登录
 */
public class Car {
    public Integer miles;
    public String color;
    public Integer size;
    private Integer prices;

    public Car() {
        //构造方法
        //开辟空间
        //把空间的首地址给this  this=0FX00
    }

    public Car(String color, Integer miles) {
        this.color = color;
        this.miles = miles;
    }

    public Car(String color, Integer miles, Integer size) {
        this(color, miles);
        this.size = size;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;  //this表示占位符，指向当前对象的首地址
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void setPrices(Integer prices) {
        this.prices = prices;
    }

    public Integer getMiles() {
        return miles;
    }

    public String getColor() {
        return color;
    }

    private Integer getPrices() {
        return prices;
    }
}
