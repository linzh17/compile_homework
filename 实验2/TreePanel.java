import java.awt.*;
import java.util.List;

import javax.swing.JPanel;

public class TreePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Node tree;             //保存整棵树
    private int gridWidth = 170;    //每个结点的宽度
    private int gridHeight = 20;    //每个结点的高度
    private int vGap = 50;          //每2个结点的垂直距离
    private int hGap = 30;          //每2个结点的水平距离

    private int startY = 10;        //根结点的Y，默认距离顶部10像素
    private int startX = 10;        //根结点的X，默认距离左端10像素

    //改进之后的程序呢就不是原文的对对齐方式啦，所以下面几行是没用的
    //private int childAlign;                     //孩子对齐方式
    //public static int CHILD_ALIGN_ABSOLUTE = 0; //相对Panel居中
    //public static int CHILD_ALIGN_RELATIVE = 1; //相对父结点居中

    private Font font = new Font("微软雅黑",Font.BOLD,14);  //描述结点的字体

    private Color gridColor = Color.BLACK;      //结点背景颜色
    private Color linkLineColor = Color.BLACK;  //结点连线颜色
    private Color stringColor = Color.WHITE;    //结点描述文字的颜色
    /*放弃了原文的内容，这是由于我们只有一种画法，而不是中间对其或是左对齐等
    public TreePanel() { this(null,CHILD_ALIGN_ABSOLUTE); }
    public TreePanel(Node n) { this(n,CHILD_ALIGN_ABSOLUTE); }
    public TreePanel(int childAlign) { this(null,childAlign); }
    public TreePanel(Node n, int childAlign) {
        super();
        setTree(n);
        this.childAlign = childAlign;
    }
    */
    public TreePanel() { this(null); }
    public TreePanel(Node n) {
        super();
        setTree(n);
    }
    public void setTree(Node n) { tree = n; }

    //重写，调用自己的绘制方法
    public void paintComponent(Graphics g) {
        //startX = (getWidth()-gridWidth)/2;//这是居中方式的设置，放弃原文方法
        super.paintComponent(g);
        g.setFont(font);
        drawAllNode(tree, g);
    }

    /**
     * 递归绘制整棵树
     * n 被绘制的Node
     * xPos 根节点的绘制X位置
     * g 绘图上下文环境
     */
    public void drawAllNode(Node n, Graphics g) {
        /*
        int y = n.getLayer()*(vGap+gridHeight)+startY;
        int fontY = y + gridHeight - 5;     //5为测试得出的值，你可以通过FM计算更精确的，但会影响速度


        g.setColor(gridColor);
        g.fillRect(x, y, gridWidth, gridHeight);    //画结点的格子

        g.setColor(stringColor);
        g.drawString(n.toString(), x, fontY);       //画结点的名字

        if (n.hasChild()) {
            List<Node> c = n.getChilds();
            int size = n.getChilds().size();
            int tempPosx = childAlign == CHILD_ALIGN_RELATIVE
                         ? x+gridWidth/2 - (size*(gridWidth+hGap)-hGap)/2
                         : (getWidth() - size*(gridWidth+hGap)+hGap)/2;

            int i = 0;
            for (Node node : c) {
                int newX = tempPosx+(gridWidth+hGap)*i; //孩子结点起始X
                g.setColor(linkLineColor);
                g.drawLine(x+gridWidth/2, y+gridHeight, newX+gridWidth/2, y+gridHeight+vGap);   //画连接结点的线
                drawAllNode(node, newX, g);
                i++;
            }
        }
        */
        //改进一个非递归算法，用我们自己计算的坐标画树，这样结点就不会重叠啦
        int y = n.getLayer()*(vGap+gridHeight)+startY;
        int x = n.getX()*(hGap+gridWidth)+startX;
        int fontY = y + gridHeight - 5;     //5为测试得出的值，你可以通过FM计算更精确的，但会影响速度


        g.setColor(gridColor);
        g.fillRoundRect(x, y, gridWidth, gridHeight, 10, 10);    //画结点的格子

        g.setColor(stringColor);
        g.drawString(n.toString(), x+5, fontY);       //画结点的名字


        if (n.hasChild()) {
            g.setColor(linkLineColor);
            g.drawLine(x+gridWidth/2, y+gridHeight, x+gridWidth/2, y+gridHeight+vGap/2);

            List<Node> c = n.getChilds();
            int i = 0;
            for (Node node : c) {
                int newX = node.getX()*(hGap+gridWidth)+startX; //孩子结点起始X
                g.setColor(linkLineColor);
                g.drawLine(newX+gridWidth/2, y+gridHeight+vGap/2, newX+gridWidth/2, y+gridHeight+vGap);
                drawAllNode(node, g);
                i++;
                if (i==c.size()) {
                    g.setColor(linkLineColor);
                    g.drawLine(x+gridWidth/2, y+gridHeight+vGap/2, newX+gridWidth/2, y+gridHeight+vGap/2);
                }
            }
        }
    }

    public Color getGridColor() { return gridColor; }
    public void setGridColor(Color gridColor) { this.gridColor = gridColor; }
    public Color getLinkLineColor() { return linkLineColor; }
    public void setLinkLineColor(Color gridLinkLine) { this.linkLineColor = gridLinkLine; }
    public Color getStringColor() { return stringColor; }
    public void setStringColor(Color stringColor) { this.stringColor = stringColor; }
    public int getStartY() { return startY; }
    public void setStartY(int startY) { this.startY = startY; }
    public int getStartX() { return startX; }
    public void setStartX(int startX) { this.startX = startX; }
    public int getGridWidth() { return gridWidth; }
    public void setGridWidth(int gridWidth) { this.gridWidth = gridWidth; }
    public int getGridHight() { return gridHeight; }
    public void setGridHeight(int gridHeight) { this.gridHeight = gridHeight; }
    public int getVGap() { return vGap; }
    public void setVGap(int vGap) { this.vGap = vGap; }
    public int getHGap() { return hGap; }
    public void setHGap(int hGap) { this.hGap = hGap; }

}
