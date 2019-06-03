
import java.util.LinkedList;
import java.util.List;

public class Node {
    private String name;                //该结点名字
    private int layer = 0;              //该结点层级
    private int x = -1;                 //x坐标
    private List<Node> childs = null;  //保存该结点的孩子

    public Node(String name) { this.name = name; }
    public Node() { this.name = null; }
    public void add(Node n) {
        if (childs==null)
            childs = new LinkedList<Node>();//这里可以改为ArrayList
        n.layer = this.layer + 1;
        setChildLayer(n);
        childs.add(n);
    }
    private void setChildLayer(Node n) {//递归设置层级，深度优先
        if (n.hasChild()) {
            List<Node> c = n.getChilds();
            for (Node node : c) {
                node.layer = n.layer + 1;
                setChildLayer(node);
            }
        }
    }
    public void CoordinateProcess(MutableInteger maxX, MutableInteger maxY) { CoordinateProcess(this, maxX, maxY); }
    public static void CoordinateProcess(Node n, MutableInteger maxX, MutableInteger maxY) {
        //max其实是用来布置画布的大小而设置的返回值
        //默认的根节点坐标是(0,0)，即x=0,layer=0
        setx(n, new MutableInteger(0), maxX, maxY);
    }
    private static void setx(Node n, MutableInteger va, MutableInteger maxX, MutableInteger maxY) {//va其实只是用来保存中间结果用来调用的
        if (n.hasChild()) {
            List<Node> c = n.getChilds();
            c.get(0).x = va.value;
            setx(c.get(0), va, maxX, maxY);
            for (int i=1; i<c.size(); i++) {
                setx(c.get(i), va, maxX, maxY);
            }
            n.x = c.get(0).x;//本结点的x是第一个孩子的x
        } else {
            n.x = va.value++;
        }
        //保存最大的x,y返回
        if (n.getX()>maxX.value) {
            maxX.value = n.getX();
        }
        if (n.getLayer()>maxY.value) {
            maxY.value = n.getLayer();
        }
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getLayer() { return layer; }
    public int getX() { return x; }
    public void setLayer(int layer) { this.layer = layer; }
    public List<Node> getChilds() { return childs; }
    public void setChilds(List<Node> childs) { this.childs = childs; }
    public boolean hasChild() { return childs==null ? false : true; }
    public void printAllNode(Node n) {//递归打印所有结点，深优
        System.out.println(n.toString());
        if (n.hasChild()) {
            List<Node> c = n.getChilds();
            for (Node node : c) {
                printAllNode(node);
            }
        }
    }
    public void printAllNode() { printAllNode(this); }
    public String getAllNodeName(Node n) {
        String s = n.toString()+"/n";
        if (n.hasChild()) {
            List<Node> c = n.getChilds();
            for (Node node : c) {
                s += getAllNodeName(node)+"/n";
            }
        }
        return s;
    }
    public String getAllNodeName() { return getAllNodeName(this); }
    public String toString() { return name; }
}
