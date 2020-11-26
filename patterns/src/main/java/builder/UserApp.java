package builder;

public class UserApp {
    public static void main(String[] args) {
        User2 user2=User2.builder()
                .userName("小密哥")
                .password("123456")
                .sex("male")
                .size("big")
                .age(123)
                .build();
        System.out.println("user2 = " + user2);

    }
}
