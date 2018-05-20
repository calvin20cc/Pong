import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class JPong extends JPanel{
  // Properties
  public int intAPaddleX = 50;
  public int intAPaddleY = 200;
  public int intBPaddleX = 720;
  public int intBPaddleY = 200;
  public int intBallX = 400;
  public int intBallY = 300;
  public int intBallChangeX = 15;
  public int intBallChangeY = 1;
  public boolean blnuppressed = false;
  public boolean blndownpressed = false;
  public boolean blnwpressed = false;
  public boolean blnspressed = false;
//  public boolean blnahitball = false;
//  public boolean blnbhitball = false;
  public boolean blnStart = false;
  public boolean blnrepaint = true;
  public int intScoreA = 0;
  public int intScoreB = 0;
  // Methods
  public void paintComponent(Graphics g){
    // double dblMoney = (double)intMoney
    Graphics2D g2d = (Graphics2D)g;
    g2d.setFont(new Font("Cooper Std Black", Font.BOLD, 45));
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, 800, 600);
    g2d.setColor(Color.WHITE);
    g2d.drawString("PONG", 320, 220);
    g2d.setFont(new Font("Cooper Std Black", Font.BOLD, 30));
    g2d.drawString("Press Space to Play", 270, 360);
    if(blnStart == true){
      g2d.clearRect(0, 0, 800, 600);
      g2d.setColor(Color.BLACK);
      g2d.fillRect(0, 0, 800, 600);
      g2d.setColor(Color.WHITE);
      if(blnuppressed == true && intBPaddleY > 1){
        intBPaddleY = intBPaddleY - 10;
      }else if(blndownpressed == true && intBPaddleY < 460){
        intBPaddleY = intBPaddleY + 10;
      }
      if(blnwpressed == true && intAPaddleY > 1){
        intAPaddleY = intAPaddleY - 10;
      }else if(blnspressed == true && intAPaddleY < 460){
        intAPaddleY = intAPaddleY + 10;
      }
      g2d.fillRect(intAPaddleX, intAPaddleY, 20, 100);
      g2d.fillRect(intBPaddleX, intBPaddleY, 20, 100);
      g2d.fillRect(399, 0, 2, 600);
      intBallX = intBallX + intBallChangeX;
      intBallY = intBallY + intBallChangeY;
      g2d.fillRect(intBallX, intBallY, 10, 10);
      if(intBallY < 0){
        intBallChangeY = intBallChangeY * -1;
        intBallChangeX = intBallChangeX * 1;
      }else if(intBallY > 550){
        intBallChangeY = intBallChangeY * -1;
        intBallChangeX = intBallChangeX * 1;
      }
      if(intBallX > 710){
        if(intBallY >= intBPaddleY && intBallY <= intBPaddleY + 34 && intBallX <= 740){
          System.out.println("top section hit");
          intBallChangeY = 1;
          intBallChangeY = intBallChangeY * -5;
          intBallChangeX = intBallChangeX * -1;
        }else if(intBallY > intBPaddleY + 34 && intBallY <= intBPaddleY + 67 && intBallX <= 740){
          System.out.println("middle section hit");
          intBallChangeY = 1;
          intBallChangeY = intBallChangeY * -2;
          intBallChangeX = intBallChangeX * -1;
        }else if(intBallY > intBPaddleY + 67 && intBallY <= intBPaddleY + 100 && intBallX <= 740){
          System.out.println("bottom section hit");
          intBallChangeY = 1;
          intBallChangeY = intBallChangeY * 5;
          intBallChangeX = intBallChangeX * -1;
        }
        
      }else if(intBallX < 70){
        if(intBallY >= intAPaddleY && intBallY <= intAPaddleY + 34 && intBallX >= 50){
          System.out.println("top section hit");
          intBallChangeY = 1;
          intBallChangeY = intBallChangeY * -5;
          intBallChangeX = intBallChangeX * -1;
        }else if(intBallY > intAPaddleY + 34 && intBallY <= intAPaddleY + 67 && intBallX >= 50){
          System.out.println("middle section hit");
          intBallChangeY = 1;
          intBallChangeY = intBallChangeY * -2;
          intBallChangeX = intBallChangeX * -1;
        }else if(intBallY > intAPaddleY + 67 && intBallY <= intAPaddleY + 100 && intBallX >= 50){
          System.out.println("bottom section hit");
          intBallChangeY = 1;
          intBallChangeY = intBallChangeY * 5;
          intBallChangeX = intBallChangeX * -1;
        }
      }
      if(intBallX > 800){
        intBallChangeX = 15;
        intBallChangeY = 1;
        intBallX = 400;
        intBallY = 300;
        intScoreA = intScoreA + 1;
        intAPaddleX = 50;
        intAPaddleY = 200;
        intBPaddleX = 720;
        intBPaddleY = 200;
        pause(1000);
        if(intScoreA == 10){
          g2d.clearRect(0, 0, 800, 600);
          g2d.setColor(Color.BLACK);
          g2d.fillRect(0, 0, 800, 600);
          g2d.setColor(Color.WHITE);
          g2d.drawString("Winner", 320, 220);
          blnrepaint = false;
        }
      }
      if(intBallX < -20){
        intBallChangeX = 15;
        intBallChangeY = 1;
        intBallX = 400;
        intBallY = 300;
        intScoreB = intScoreB + 1;
        intAPaddleX = 50;
        intAPaddleY = 200;
        intBPaddleX = 720;
        intBPaddleY = 200;
        pause(1000);
        if(intScoreB == 10){
          g2d.clearRect(0, 0, 800, 600);
          g2d.setColor(Color.BLACK);
          g2d.fillRect(0, 0, 800, 600);
          g2d.setColor(Color.WHITE);
          g2d.drawString("Winner", 320, 220);
          blnrepaint = false;
        }
      }
      g2d.setFont(new Font("BankGothic Lt BT", Font.BOLD, 45));
      g2d.drawString(Integer.toString(intScoreA), 200, 40);
      g2d.drawString(Integer.toString(intScoreB), 600, 40);
    }
  }
  public static void pause(int intMS){
    try{
      Thread.sleep(intMS);
    }catch(InterruptedException e){
    }
  }
  // Constructors
  public JPong(){
    super();
  }
}