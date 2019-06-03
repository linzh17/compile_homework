package exceptions;

public class CommentException extends Exception{
    private static final long serialVersionUID = 1L;
    public CommentException() {
        this("error：注释 不规范 .");
    }
    public CommentException(String msg) {
        super("error：注释 不规范 （:" + msg + ")");
    }
}