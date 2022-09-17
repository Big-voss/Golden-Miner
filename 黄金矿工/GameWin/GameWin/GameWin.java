package GameWin;

import javax.swing. *;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameWin  extends JFrame{
    //存储金块,石头
    ArrayList<Object> objectList = new ArrayList<Object>();
    Bg bg = new Bg();
    Line line = new Line(this);

    {
        //是否可以放置
        boolean isPlace =true;
        //创建矿石产生的数量
        for(int i = 0; i < 6; i++){
            double random = Math.random(); //设置double的随机类型random变量,使产生随机数
            Gold gold; //添加成员变量,用于存放当前生成的金块
            if(random < 0.3) {
                gold = new GoldMini();
            }
            else if(0.3 < random && random < 0.7){
                gold = (new Gold());
            }
            else{
                gold = (new GoldPlus());

                for(Object obj:objectList){
                    if(gold.getRec().intersects(obj.getRec())){
                        //金块不能放置,须要重新生成
                        isPlace = false;
                        i--;
                    }
                }
                if(isPlace){
                    objectList.add(gold);
                }
                else{isPlace = true ; i--;}
            }

        }
        //创建石头产生的数量
        for(int i = 0; i < 3; i++){
            objectList.add(new Rock());
        }
    }

    Image offScreenImage;

    void launch(){
        this.setVisible(true);
        this.setSize(947,1000);
        this.setLocationRelativeTo(null);
        this.setTitle("宗兆斌的黄金矿工");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1&&line.state==0){
                    line.state = 1;
                }
                //抓取返回,点击右键
                if(e.getButton()==3&&line.state==3){
                    Bg.waterFlag =true;
                    Bg.waterNum--;
                }
            }
        });

        //使线动起来,进行旋转
        while(true){
            repaint();

            //使线转圈的延迟效果
            try {
                Thread.sleep(100);//红线摆动的频率
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void  paint(Graphics g){
        offScreenImage = this.createImage(947,1000);
        Graphics gImage = offScreenImage.getGraphics();

        bg.paintSelf(gImage);

        //绘制金块
        for(Object obj:objectList)
        {
            obj.painSelf(gImage);
        }
        //绘制红线
        line.paintSelf(gImage);

        g.drawImage(offScreenImage,0,0,null);
    }


    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}