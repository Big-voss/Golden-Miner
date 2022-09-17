package GameWin;

import java.awt.*;

public class Gold extends Object{

    Gold(){
        this.x = (int)(Math.random()*900);
        this.y = (int)(Math.random()*500+400);
        this.width = 80;
        this.height = 87;
        this.flag = false;
        this.m = 80;
        this.count = 4;
        this.type = 1;
        this.img = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/ks.jpg");
    }
}

class GoldMini extends Gold{
    GoldMini(){
        this.width = 60;
        this.height = 63;
        this.m = 15;
        this.count = 2;
        this.img = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/ks1.jpg");
    }
}
class GoldPlus extends Gold{
    GoldPlus(){
        this.x = (int)(Math.random()*750);
        this.width = 105;
        this.height = 128;
        this.m = 60;
        this.count = 8;
        this.img = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/ks2.jpg");
    }
}
