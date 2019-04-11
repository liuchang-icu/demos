import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkList {
    public static void main(String args[]){
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        System.out.print( String.join(",",list));

        List students = new ArrayList();
        for(int a= 0;a<5 ;a++){
            students.add(new Student(a+""));
        }
        System.out.print( String.join(",",list));
        System.out.print( "哈哈哈啊哈");
    }
}
