import java.io.*;
import java.util.Random;
class Creator{
    public String expression = "";
    // E->E+T | E-T | T
    void E(){
        if (expression.length() <50){
            Random rand=new Random();
            int i=(int)(Math.random()*2);
            switch(i){
                case 0:
                        E() ;
                        int j =(int)(Math.random()*2);
                        switch(j){
                            case 0:expression=expression+'+';
                                break;
                            case 1:expression=expression+'-';
                                break; 
                        }
                        T();
                        break;
                case 1: T();break;
            }
        }
        else {
            T();
        }
    }
    // T-> T*F | T/F | F
    void T(){
        if (expression.length() <50){
            Random rand=new Random();
            int i=(int)(Math.random()*2);
            switch(i){
                case 0:
                        T() ;
                        int j =(int)(Math.random()*2);
                        switch(j){
                            case 0:expression=expression+'*';
                                break;
                            case 1:expression=expression+'/';
                                break; 
                        }
                        F();
                        break;
                        
                case 1: F();break;
            }
        }
        else{
            F();
        }
    }
    // F -> Number | (E)
    void F(){
        if (expression.length() <50){
            Random rand=new Random();
            int i=(int)(Math.random()*3);
            switch(i){
                case 0:
                        Number() ;
                        break;
                case 1: expression = expression+'(';
                        E();
                        expression = expression+')';
                    break;
                case 2: expression = expression+'!';
                        E();
                break;
            }
        }
        else{
            Number();
        }
    }
    void Number(){
        Random rand=new Random();
        int i=(int)(Math.random()*2);
        switch(i){
            case 0:
                int j=(int)(Math.random()*1000);
                Integer jt = j;
                expression = expression+jt.toString();
                break;
            case 1:
                int k=(int)(Math.random()*1000);
                Integer kt = k;
                expression = expression+kt.toString();
                k=(int)(Math.random()*1000);
                kt = k;
                expression = expression+'.'+kt.toString();
                break;
        }

    }
    String startCreator(){
        expression = "";
        E();
        //System.out.println(expression);
        return expression+";"; 
    }

}
