package builder;


public class User {
    private String userName;
    private String password;
    private Integer age;
    private String sex;
    private String size;

    public User() {
    }

    private User(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.age = builder.age;
        this.sex = builder.sex;
        this.size = builder.size;
    }

    public static class Builder{
        private String userName;
        private String password;
        private Integer age;
        private String sex;
        private String size;

        public static Builder of(){
            return new Builder();
        }

        public Builder userName(String userName){
            this.userName=userName;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }

        public Builder age(Integer age){
            this.age=age;
            return this;
        }

        public Builder sex(String sex){
            this.sex=sex;
            return this;
        }

        public Builder size(String size){
            this.size=size;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
