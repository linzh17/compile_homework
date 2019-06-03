
public class MutableInteger {//为了函数返回值而写的类
    public int value;
    public MutableInteger(int x) { value = x; }
    public MutableInteger() { value = 0; }
    public boolean equals(int x) {
        if ( x==value )
            return true;
        else
            return false;
    }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
}
