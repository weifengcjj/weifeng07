package demo;

import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Student {
    private String zy;
    private String name;

    private int age;
    private String  sex;
    private List<Student> list;
    public Student() {
    }

    public Student(String name, int age, String sex,String zy) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.zy=zy;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Student> getList() {
        return list;
    }

    public void addList(List<Student> list1) {
        this.list.add((Student) list1);
    }
}
