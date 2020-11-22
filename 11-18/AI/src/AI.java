import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y,leftflag,rightflag,upflag,downflag;
	Image currentImg;
	Image heroleftImg[]=new Image[3],herorightImg[]=new Image[3],heroupImg[]=new Image[3],herodownImg[]=new Image[3];
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			//左
			for(i=0;i<heroleftImg.length;i++)
			{      heroleftImg[i]=Image.createImage("/sayo"+i"2.png");}
			/*leftImg=Image.createImage("/sayo12.png");
	        img1=Image.createImage("/sayo02.png");
			img2=Image.createImage("/sayo22.png");*/

			//右
			for(i=0;i<herorightImg.length;i++)
			{      herorightImg[i]=Image.createImage("/sayo"+i"6.png");}
			/*
			rightImg=Image.createImage("/sayo16.png");
            img3=Image.createImage("/sayo06.png");
			img4=Image.createImage("/sayo26.png");
			*/

			//上
            for(i=0;i<heroupImg.length;i++)
			{      heroupImg[i]=Image.createImage("/sayo"+i"4.png");}
			/*
			upImg=Image.createImage("/sayo24.png");
			img5=Image.createImage("/sayo04.png");
			img6=Image.createImage("/sayo24.png");
			*/

			//下
		    for(i=0;i<herodownImg.length;i++)
			{      herodownImg[i]=Image.createImage("/sayo"+i"0.png");}
			/*
			downImg=Image.createImage("/sayo10.png");
			img7=Image.createImage("/sayo00.png");
			img8=Image.createImage("/sayo20.png");
			*/
			currentImg=herodownImg[1];
			x=120;
			y=100;
			leftflag=1;
			rightflag=1;
			upflag=1;
			downflag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
		
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		    if(action==LEFT)
			{
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
		    	if(leftflag==1)
				{
	    	    	currentImg=heroleftImg[1];
			        leftflag++;

				}
		    	else if(leftflag==2)
				{
	                currentImg=heroleftImg[2];
					leftflag=1;
				}
			x=x-1;
		}

			if(action==RIGHT)
			{
				if(rightflag==1)
				{
			        currentImg=herorightImg[0];
		        	rightflag=2;
				}
				else if (rightflag==2)
				{
	                currentImg=herorightImg[2];
					rightflag=1;
				}
			x=x+1;		
			}
		    if(action==UP)
			{
			 if(upflag==1)
				{
		    	currentImg=heroupImg[0];
			    upflag=2;
				}
			 else if(upflag==2)
				{
	                currentImg=heroupImg[2];
					upflag=1;
				}
			y=y-1;
			}
			if(action==DOWN)
			{
				if(downflag==1)
				{
	      		    currentImg=herodownImg[0];
		    	    downflag=2;
				}
				else if(downflag==2)
				{
	                currentImg=herodownImg[2];
					downflag=1;
				}
			y=y+1;
			}
			repaint();
	}
}