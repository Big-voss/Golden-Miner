package GameWin;

import java.awt.*;

public class Rock extends Object {
    Rock(){
        this.x = (int)(Math.random()*900);
        this.y = (int)(Math.random()*500+400);
        this.width = 50;
        this.height = 41;
        this.flag = false;
        this.m = 150;
        this.count = 1;
        this.type = 2;
        this.img = Toolkit.getDefaultToolkit().getImage("F:/JAVA 游戏项目/黄金矿工/GameWin/imgs/st.png");
    }
}
