package oob;

/**
 * @author mixuan.chen
 * @date 2020/11/5
 * @content 登录
 */
public class CarApp {
    public static void main(String[] args) {
        Car littleCar=new Car();
        littleCar.setColor("blue");
        System.out.println(littleCar.getColor());

        Car bigCar=new Car("red",100);
        bigCar.setColor("yellow");
        System.out.println(bigCar.getColor());
    }
}
