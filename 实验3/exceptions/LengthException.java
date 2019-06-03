package exceptions;

public class LengthException extends Exception{
    private static final long serialVersionUID = 1L;
    public LengthException() {
        this("error：标识符长度超过24 .");
    }
    public LengthException(String msg) {
        super("error：标识符长度超过24 （:" + msg + ")");
    }
}