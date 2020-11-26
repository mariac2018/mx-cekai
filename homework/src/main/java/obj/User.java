package obj;

public class User{
    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null||!(o instanceof User)){
            return false;
        }

        User u=(User)o;

        if(this.getId()==u.getId()&&this.getName().equals(u.getName())&&this.getAge()==u.getAge()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 17 * result + id.hashCode();
        result = 17 * result + age.hashCode();
        return result;
    }

//    @Override
//    public int compareTo(User o) {
//        if(this.getId()!=o.getId()){
//            return this.getId()-o.getId();
//        }
//        //如果id相等,用name来比较
//        if(this.getName()!=o.getName()){
//            return this.getName().compareTo(o.getName());
//        }
//        //如果name也相等，则用age比较
//        return this.getAge()-o.getAge();
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
