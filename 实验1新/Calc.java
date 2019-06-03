//Calc2.java
import java.io.*;
public class Calc{
    public static void main(String argv[])throws Exception{
        
        
        Creator creator = new Creator();
        OutputStream f = new FileOutputStream(argv[0]);

        System.out.println("开始生成和写入测试数据");

        for(int i=0;i<100;i++){
            f.write((creator.startCreator()+"\r\n").getBytes());
        }

        System.out.println("写入文件结束");

        System.out.println("开始表达式中缀转后缀");

        parser p=new parser(new lexer(new FileReader(argv[0])));
        try{
        p.parse();
        
        }catch (Exception e) {

            //p.parse();
    
          } 
        System.out.print("一共有"+(p.lineNumber()-1)+"个输入数据，");
        System.out.println("错误输入"+p.errors+"个");
    }
}