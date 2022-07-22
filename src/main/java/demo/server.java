package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class server {
    List<Student> listben=new ArrayList<>();//放本科生的集合
    List<Student> listyan=new ArrayList<>();//放研究生的集合
    public  void addben(Student s)
    {
        listben.add(s);
    }
    public void removeben(Student s)
    {
        System.out.println(s.getName()+"信息已被删除!");
        listben.remove(s);
    }

    public  void addyan(Student s)
    {
        listyan.add(s);
    }
    public void removeyan(Student s)
    {
        System.out.println(s.getName()+"信息已被删除!");
        listyan.remove(s);
    }

    public List<Student> getListben() {
        return listben;
    }

    public void setListben(List<Student> listben) {
        this.listben = listben;
    }

    public List<Student> getListyan() {
        return listyan;
    }

    public void setListyan(List<Student> listyan) {
        this.listyan = listyan;
    }
}
