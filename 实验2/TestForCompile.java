import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;


public class TestForCompile extends JFrame{

    public Node tree;

    private static final long serialVersionUID = 1L;

    public TestForCompile(Node t){
        super("Test Draw Tree");
        tree = t;
        MutableInteger maxx = new MutableInteger();
        MutableInteger maxy = new MutableInteger();
        Node.CoordinateProcess(t, maxx, maxy);//画树前必须对树的坐标处理
        initComponents(maxx, maxy);
    }
    public void initComponents(MutableInteger maxX, MutableInteger maxY){
        TreePanel panel1 = new TreePanel(tree);
        /*
        TreePanel panel2 = new TreePanel(tree);
        panel2.setBackground(Color.BLACK);
        panel2.setGridColor(Color.WHITE);
        panel2.setLinkLineColor(Color.WHITE);
        panel2.setStringColor(Color.BLACK);
        */
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout());
        contentPane.add(panel1);//我们就画一棵树，原文画了两棵树我都注释掉了
        //contentPane.add(panel2); 


        JScrollPane scrollPane = new JScrollPane(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //上一步设置了滚动条是否可见，大家可以改成as_needed看看效果
        scrollPane.setViewportView(contentPane);//这一步是能看到画面的必要一步
        //这一步开始设置了画板的大小，这个大小是根据最大的x,y和各个结点的长宽和间距计算的，然后把这个画板add到一个带滚动条的画板里就能滚动着看啦
        contentPane.setPreferredSize(
                new Dimension(
                        (maxX.getValue())*(panel1.getGridWidth()+panel1.getHGap()) + panel1.getGridWidth() + panel1.getStartX()*2,
                        (maxY.getValue())*(panel1.getGridHight()+panel1.getVGap()) + panel1.getGridHight() + panel1.getStartY()*2));
        contentPane.revalidate();
        //horizontalScandocDRPane.add(scrollPane);
        //this.add(scrollPane);
        this.add(scrollPane,BorderLayout.CENTER);
    }
}
