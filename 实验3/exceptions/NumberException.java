package exceptions;

public class NumberException extends Exception{
    private static final long serialVersionUID = 1L;
    public NumberException() {
        this("error：Number 不规范 .");
    }
    public NumberException(String msg) {
        super("error：Number 不规范 （:" + msg + ")");
    }
}