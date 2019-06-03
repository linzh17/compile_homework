package exceptions;

public class RangeException extends Exception{
    private static final long serialVersionUID = 1L;
    public RangeException() {
        this("error： 常量超出范围.");
    }
    public RangeException(String msg) {
        super("error： 常量超出范围 (:" + msg + ")");
    }
}