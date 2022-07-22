package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class Test {
    public static void main(String[] args) {
        Student student=new Student("张三",18,"男","土木工程");
        Student student1=new Student("李四",19,"女","it");
        server s = new server();
        List<Student> list=new ArrayList<>();
        //list.add(student);

        s.addben(student);
        s.addyan(student1);
        System.out.println("本科");
        for(Student i:s.getListben())
        {
            System.out.println("姓名："+i.getName()+" 年龄："+i.getAge()+" 性别："+i.getSex()+" 专业："+i.getZy());
        }
        s.removeben(student);
        System.out.println("研究生");
        for(Student i:s.getListyan())
        {
            System.out.println("姓名："+i.getName()+" 年龄："+i.getAge()+" 性别："+i.getSex()+" 专业："+i.getZy());
        }
    }
}
