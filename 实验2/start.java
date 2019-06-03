//Calc2.java
import java.io.*;
import javax.swing.JFrame; 
import javax.swing.JPanel;  
 
public class start{
    public static void main(String argv[])throws Exception{
        
        parser p=new parser(new lexer(new FileReader(argv[0])));
        int i = argv[0].indexOf(".txt");
        //System.out.println(argv[0].substring(0,i));
        p.name = argv[0].substring(0, i);
        p.parse();
        //p.treeroot.printAllNode(p.treeroot);
        TestForCompile frame = new TestForCompile(p.treeroot);//调用构造函数其实就完成了绘图

        frame.setSize(800, 600);//设置窗口的大小，其实窗口这么小放不下我们这么大的树，所以我们只要让画板可以有滚动条就能显示全了（这个原文没有哦）
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          
        
    }
}