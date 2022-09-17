package GameWin;

import javax.annotation.Generated;
import java.awt.*;

public class Object {
    //公共属性:
    //坐标:
    int x;
    int y;
    //宽高:
    int width;
    int height;
    //图片:
    Image img;
    //标记是否能移动
    boolean flag;
    //质量
    int m;

    //积分
    int count;
    //设置类型:类型1为金块,2为石块
    int type;

    void painSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }
    //获取矿石,石头的宽度
    public int getWidth(){
        return width;
    }

    //获取矩形(防止金块,石块重叠)
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
