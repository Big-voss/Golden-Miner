package GameWin;

import java.awt.*;

public class Bg {
    //总分
    static int count = 0;
    //药水数量
    static int waterNum = 3;
    //药水状态,默认为forse,使用为true
    static boolean waterFlag = false;
    Image bg = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/bg.jpg");
    Image kg = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/kg.png");
    Image ks = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/ks.jpg");
    Image st = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/st.jpg");
    Image water = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs//ys.jpg");

    //绘制
    void paintSelf(Graphics g){
        g.drawImage(bg,0,0,null);
        g.drawImage(kg,430,280,null);
        g.drawImage(water,600,300,null);
        drawWord(g,30,Color.BLACK,"积分: "+count,30,150);
        //绘制药水
        g.drawImage(water,600,300,null);
        drawWord(g,35,Color.BLACK,"*"+waterNum,650,300);
    }

    public static void drawWord(Graphics g,int size,Color color,String str, int x,int y){
        //设置现实积分处
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}
