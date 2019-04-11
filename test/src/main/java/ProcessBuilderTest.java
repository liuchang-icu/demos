import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderTest {
    //测试脚本运行

    public static void main(String args[]){

        doShell();

    }
    public   static boolean doShell(){

        ProcessBuilder pb = new ProcessBuilder("sh ");

        try {
            Process p =  pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s ;
            while((s=bf.readLine())!=null){
                System.out.println(s);
            }
            //用于存储执行命令的错误信息
          /*  BufferedReader errors=new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while((s=errors.readLine())!=null){
                System.err.println(s);

            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }
}
