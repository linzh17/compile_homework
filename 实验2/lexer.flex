//scanner.flex
//用户代码段
import java_cup.runtime.*;
import java.io.*;

%%
//参数设置和声明段 
%class lexer 
%line 
%column 
%cup
%unicode

%{
    public static void init(){}
    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn); 
    }
    private Symbol symbol(int type,Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }
%}
digit=[0-9]
letter=[A-Za-z]
ID={letter}+
number={digit}+
LineTerminator=\r|\n|\r\n
WhiteSpace={LineTerminator}|[ /t/f]
%%
//词法规则段

    ";" { return symbol(sym.SEMI); /**//*case ";"*/}
    "," { return symbol(sym.DOT);/**//*case ","*/ }
    "<" { return symbol(sym.RELOP1);/**//*case "<"*/ }
    "<=" { return symbol(sym.RELOP2);/**//*case "<="*/ }
    ">" { return symbol(sym.RELOP3);/**//*case ">"*/ }
    ">=" { return symbol(sym.RELOP4);/**//*case ">="*/ }
    "==" { return symbol(sym.RELOP5);/**//*case "=="*/ }
    "!=" { return symbol(sym.RELOP6);/**//*case "!="*/ }
    "&&" { return symbol(sym.RELOP7);/**//*case "&&"*/ }
    "=" { return symbol(sym.RELOP8);/**//*case "="*/ }
    "+" { return symbol(sym.PLUS); /**//*case "+"*/}
    "-" { return symbol(sym.MINUS); /**//*case "-"*/}
    "*" { return symbol(sym.TIMES); /**//*case "*"*/}
    "/" { return symbol(sym.DIVIDE); /**//*case "/"*/}
    //"%" { return symbol(sym.MOD); /**//*case "%"*/}
    //"!" { return symbol(sym.REVERSE); /**//*case "!"*/}
    "(" { return symbol(sym.LPAREN); /**//*case "("*/}
    ")" { return symbol(sym.RPAREN); /**//*case ")"*/}
    "[" { return symbol(sym.LB);/**//*case "["*/ }
    "]" { return symbol(sym.RB);/**//*case "]"*/ }
    "{" { return symbol(sym.LC);/**//*case "{"*/ }
    "}" { return symbol(sym.RC);/**//*case "}"*/ }
    "else" { return symbol(sym.ELSE);/**//*case "else"*/ }
    "if" { return symbol(sym.IF);/**//*case "if"*/ }
    //"int" { return symbol(sym.INT);/**//*case "int"*/ }
    "return" { return symbol(sym.RETURN);/**//*case "return"*/ }
    //"void" { return symbol(sym.VOID);/**//*case "void"*/ }
    "while" { return symbol(sym.WHILE);/**//*case "while"*/ }
    "RANDOM" { return symbol(sym.RANDOM);/**//*case "RANDOM"*/ }
    "var" {return symbol(sym.VAR);/**//*case "var"*/}
    "main" {return symbol(sym.MAIN);/**//*case "main"*/}
    "print" {return symbol(sym.PRINT);/**//*case "print"*/}
    {number} { return symbol(sym.NUMBER,new Integer(yytext())); /**//*case {number}*/}
    {ID} { return symbol(sym.ID,new String(yytext())); /**//*case {ID}*/}
    {WhiteSpace} {/**//*case {WhiteSpace}:  do nothing*/}
    

. { 
    System.out.println("Error:"+yytext()+" 是不合法的符号"); 
}
 
