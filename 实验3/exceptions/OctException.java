package exceptions;

public class OctException extends Exception{
    private static final long serialVersionUID = 1L;
    public OctException() {
        this("error：八进制常量 不规范 .");
    }
    public OctException(String msg) {
        super("error：八进制常量 不规范 （:" + msg + ")");
    }
}