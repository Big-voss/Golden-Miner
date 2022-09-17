package GameWin;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.*;
import java.sql.SQLOutput;

public class Line {
    //起点坐标
    int x = 470;
    int y = 380;
    //终点坐标
    int endx = 947;
    int endy = 1000;
    //规定初始线长
    double length = 80;
    //线长最小值
    double MIN_length = 80;
    //线长最大值
    double MAX_length = 750;
    double angle = 0;
    //规定线的方向参数
    int dir = 1;
    //状态为0,自由摇摆;为1,抓取;为2,收回;3抓取返回
    int state;
    //钩爪图片:
    Image zz = Toolkit.getDefaultToolkit().getImage("D:/idea/GameWin/imgs/zz.jpg");

    GameWin frame;

    Line(GameWin frame){
        this.frame = frame;
    }
    //构造判断物体是否抓取到尽快的方法

    void logic(){
        for(Object obj:this.frame.objectList){
            if(endx > obj.x && endx < obj.x + obj.width && endy > obj.y && endy < obj.y + obj.height){
                state = 3;
                obj.flag = true;//金块,石头位置改变
            }
        }
    }
//绘制方法
    void lines(Graphics g){
        endx = (int) ( x + length * Math.cos(angle * Math.PI));
        endy = (int) ( y + length * Math.sin(angle * Math.PI));
        g.setColor(Color.red);
        g.drawLine(x,y,endx + 1,endy + 1);
        g.drawLine(x,y,endx,endy);
        g.drawLine(x,y,endx - 1,endy - 1);
        g.drawImage(zz,endx - 50,endy - 36,null);
    }

    void paintSelf(Graphics g){
        logic();//调用进行是否抓取到金块的判断
        switch ((state)){
        case 0:
            if(angle < 0.1){
                dir = 1;
          }
            else if(angle > 0.9){
                dir = -1;
          }
            angle = angle + 0.05 * dir;
                lines(g);
                 break;
            case 1:
                if(length<MAX_length) {
                    length = length + 15;
                    lines(g);
                }
                else {
                    state = 2;
                }
                break;
            case 2:
                if(length>MIN_length){
                    length = length - 15;
                    lines(g);
                }
                else{
                    state = 0;
                }
            case 3:
                int m = 1;
                if(length>MIN_length) {
                    length = length - 15;
                    lines(g);
                    for(Object obj: this.frame.objectList){
                        if(obj.flag){
                            m = obj.m;
                            obj.x = endx - obj.getWidth()/2; //矿石和石块的宽度/2
                            obj.y = endy;
                            if(length <= MIN_length){
                                obj.x = 200;
                                obj.y = -200;
                                obj.flag = false; //将其他金块位置还原
                                Bg.waterFlag = false;
                                //显示加分在背景中
                                Bg.count+=obj.count;
                                state = 0;
                            }
                            if(Bg.waterFlag){
                                if(obj.type == 1);{//使用药水,金块快速拉去
                                    m = 1;
                                }
                                if(obj.type == 2);{//使用药水,若石块爆破
                                    obj.x = 200;
                                    obj.y = -200;
                                    obj.flag = false; //将其他金块位置还原
                                    Bg.waterFlag = false;
                                    state = 2;
                                }
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

    }
        }


}
