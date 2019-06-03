
import java.io.*;

 
public class start{
    public static void main(String argv[])throws Exception{
        
        parser p=new parser(new lexer(new FileReader(argv[0])));
        
        p.parse();
        
    }
}