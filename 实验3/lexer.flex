//lexer.flex
//用户代码段
import java_cup.runtime.*;
import java.io.*;
import exceptions.*;

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
Number = [1-9]+[0-9]* | 0[0-7]*
IllegalNumber = {Number}+{IDENTIFIER}+
IllegalOct = 0[0-7]*[8|9]+[0-9]*


COMMENT = "(*"~"*)"
IllegalComment = "(*" ([^\*] | "*"+[^\)])* | ([^\(]|"("+[^\*])* "*)"

/*[:jletter:]       isJavaIdentifierStart()
    [:jletterdigit:]  isJavaIdentifierPart()*/
IDENTIFIER = [:jletter:][:jletterdigit:]*

LineTerminator=\r|\n|\r\n
WhiteSpace={LineTerminator}|[ \t\f]
%%
//词法规则段

    ";" { return symbol(sym.SEMI); /**//*case ";"*/}
    "." { return symbol(sym.DOT);/**//*case "."*/ }
    "," { return symbol(sym.COMMA);/**//*case ","*/ }
    ":" { return symbol(sym.COLON);/**//*case ":"*/ }

    "<" { return symbol(sym.RELOP1);/**//*case "<"*/ }
    "<=" { return symbol(sym.RELOP2);/**//*case "<="*/ }
    ">" { return symbol(sym.RELOP3);/**//*case ">"*/ }
    ">=" { return symbol(sym.RELOP4);/**//*case ">="*/ }
    "=" { return symbol(sym.RELOP5);/**//*case "="*/ }
    "#" { return symbol(sym.POUND);/**//*case "#"*/ }

    ":=" { return symbol(sym.RELOP8);/**//*case ":="*/ }
    "+" { return symbol(sym.PLUS); /**//*case "+"*/}
    "-" { return symbol(sym.MINUS); /**//*case "-"*/}
    "*" { return symbol(sym.TIMES); /**//*case "*"*/}
    "DIV" { return symbol(sym.DIVIDE); /**//*case "DIV"*/}
    "MOD" { return symbol(sym.MOD); /**//*case "MOD"*/}
    "OR" { return symbol(sym.OR); /**//*case "OR"*/}
    "&" { return symbol(sym.RELOP7);/**//*case "&"*/ }
    "~" { return symbol(sym.REVERSE); /**//*case "~"*/}   

    "(" { return symbol(sym.LPAREN); /**//*case "("*/}
    ")" { return symbol(sym.RPAREN); /**//*case ")"*/}
    "[" { return symbol(sym.LB);/**//*case "["*/ }
    "]" { return symbol(sym.RB);/**//*case "]"*/ }

    "ELSE" { return symbol(sym.ELSE);/**//*case "ELSE"*/ }
    "ELSIF" { return symbol(sym.ELSIF);/**//*case "ELSIF"*/ }
    "IF" { return symbol(sym.IF);/**//*case "IF"*/ }
    "THEN" { return symbol(sym.THEN);/**//*case "THEN"*/ }

    "INTEGER" { return symbol(sym.INTEGER);/**//*case "INTEGER"*/ }
    "BOOLEAN" { return symbol(sym.BOOLEAN);/**//*case "BOOLEAN"*/ }
    "RECORD" { return symbol(sym.RECORD);/**//*case "RECORD"*/ }
    "ARRAY" { return symbol(sym.ARRAY);/**//*case "ARRAY"*/ }
    "OF" { return symbol(sym.OF);/**//*case "OF"*/ }
    //"void" { return symbol(sym.VOID);/**//*case "void"*/ }

   // "TRUE" { return symbol(sym.TRUE);/**//*case "TRUE"*/ }
    //"FALSE" { return symbol(sym.FALSE);/**//*case "FALSE"*/ }

    "WHILE" { return symbol(sym.WHILE);/**//*case "WHILE"*/ }
    "DO" { return symbol(sym.DO);/**//*case "DO"*/ }
    "BEGIN" { return symbol(sym.BEGIN);/**//*case "BEGIN"*/ }
    "END" { return symbol(sym.END);/**//*case "END"*/ }

    "VAR" {return symbol(sym.VAR);/**//*case "VAR"*/}
    "CONST" { return symbol(sym.CONST);/**//*case "CONST"*/ }
    "TYPE" { return symbol(sym.TYPE);/**//*case "TYPE"*/ }

    "MODULE" { return symbol(sym.MODULE);/**//*case "MODULE"*/ }
    "PROCEDURE" { return symbol(sym.PROCEDURE);/**//*case "PROCEDURE"*/ }
    "Write" {return symbol(sym.WRITE);/**//*case "Write"*/}
    "Read" {return symbol(sym.READ);/**//*case "Read"*/}
    "Writeln" {return symbol(sym.Writeln);/**//*case "Writeln"*/}



    {Number} {
        try{ 
            if(yylength() > 12)
            throw new RangeException();
            return symbol(sym.NUMBER,new Integer(yytext())); /**//*case {Number}*/
        }catch(RangeException e){}
    }
    {IDENTIFIER} {
        try{
            if(yylength() > 24)
                throw new LengthException();
            return symbol(sym.IDENTIFIER,new String(yytext())); /**//*case {Identifer}*/
        }catch(LengthException e){}
    }
    {COMMENT} {return symbol(sym.COMMENT,new String(yytext()));} /**//*case {COMMENT}*/
    {IllegalNumber} {try{
        throw new NumberException();
        }catch(NumberException e){}
    }/**//*case {COMMENT}*/
    {IllegalOct} {try{
        throw new OctException();
        }catch(OctException e){}
        }/**//*case {IllegalOct}*/
    {IllegalComment} {
        try{
        throw new CommentException();
        }catch(CommentException e){}
        }/**//*case {IllegalComment}*/

    {WhiteSpace} {/**//*case {WhiteSpace}:  do nothing*/}
    

. { 
    System.out.println("Error:"+yytext()+" 是不合法的符号"); 
}
 
