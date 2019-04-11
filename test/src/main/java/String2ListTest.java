import java.util.Arrays;
import java.util.List;

public class String2ListTest {


    public static void main(String args[]){

    String  a = "a,b,c,";
    String  b = ",a";

    List list = Arrays.asList(a.split(","));
    //System.out.print(list.get(list.size()-1));
    List q = Arrays.asList(b.split(","));
    System.out.print(q.get(q.size()-1));
        System.out.print("2:"+q.get(q.size()-2));
    }
}
