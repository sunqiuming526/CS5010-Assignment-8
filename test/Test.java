import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

//import org.junit.Test;

/**
 * @program: CS5010-Assignment-7
 * @description:
 * @author: Nan Sun
 * @create: 2019-11-05 20:14
 **/

public class Test {

  public static void main(String[] args) throws Exception {
    File file = new File("test\\image.jpg");
    BufferedImage bi = null;
    try {
      bi = ImageIO.read(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    int width = bi.getWidth();
    int height = bi.getHeight();
    int minx = bi.getMinX();
    int miny = bi.getMinY();

    //Color myWhite = new Color(255, 255, 255); // Color white
    double[][] grey = new double[3][3];
    grey[0][0] = 0.2126;
    grey[0][1] = 0.7152;
    grey[0][2] = 0.0722;
    grey[1][0] = 0.2126;
    grey[1][1] = 0.7152;
    grey[1][2] = 0.0722;
    grey[2][0] = 0.2126;
    grey[2][1] = 0.7152;
    grey[2][2] = 0.0722;


    int[] rgb = new int[3];
    for (int i = minx; i < width; i++) {
      for (int j = miny; j < height; j++) {
        int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);

        int[] res = matrix(grey, rgb);
        bi.setRGB(i, j, new Color(res[0], res[1], res[2]).getRGB());

      }
    }

    File f = new File("test\\res.png");
    ImageIO.write(bi, "png", f);

  }

//  public static int[] getImagePixel() throws Exception {
//    String filename = "test\\image.jpg";
//    File fileCar = new File("test" + "\\" + filename + "1.txt");
//    FileOutputStream fos = new FileOutputStream(fileCar);
//    BufferedOutputStream bos = new BufferedOutputStream(fos);
//
//    ///输出S 的输出流
//    File fileS=new File("test"+"\\"+filename+"2.txt");
//    FileOutputStream fosS = new FileOutputStream(fileS);
//    BufferedOutputStream bosS = new BufferedOutputStream(fosS);
//
//    int[] rgb = new int[3];
//    File file = new File("test\\image.jpg");
//    BufferedImage bi = null;
//    try {
//      bi = ImageIO.read(file);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    int width = bi.getWidth();
//    int height = bi.getHeight();
//    int minx = bi.getMinX();
//    int miny = bi.getMinY();
//
//    //计数器
//    int[] counter = new int[2];
//    counter[0] = counter[1] = 0;//初始化
//    System.out.println("width=" + width + ",height=" + height + ".");
//    bos.write(("width=" + width + ",height=" + height + ".\n").getBytes());
//    System.out.println("minx=" + minx + ",miniy=" + miny + ".");
//    bos.write(("minx=" + minx + ",miniy=" + miny + ".\n").getBytes());
//    for (int i = minx; i < width; i++) {
//      for (int j = miny; j < height; j++) {
//        int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
//        rgb[0] = (pixel & 0xff0000) >> 16;
//        rgb[1] = (pixel & 0xff00) >> 8;
//        rgb[2] = (pixel & 0xff);
//        System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");
//        bos.write(("i=" + i + ",j=" + j + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")\n").getBytes());
//        if (rgb[0] + rgb[1] + rgb[2] >= 100) {
//          counter[0] = counter[0] + 1;
//        } else {
//          counter[1] = counter[1] + 1;
//        }
//        //判定S
//        if (rgb[0] + rgb[1] + rgb[2] >= 100) {
//          bosS.write(( + i + " " + j + " 1 " + "\r").getBytes());
//        } else {
//          bosS.write(( + i + " " + j + " 0 " + "\r").getBytes());
//        }
//
//      }
//    }
//    bos.flush();
//    bos.close();
//    fos.flush();
//    fos.close();
//    bosS.flush();
//    bosS.close();
//    fosS.flush();
//    fosS.close();
//    return counter;
//  }

  private static int[] matrix(double[][] transMatrix, int[] rgbMatrix) {
    int[] res = new int[3];

    for (int i = 0; i < 3; i++) {
      int r = 0;
      for (int j = 0; j < 3; j++) {
        r += transMatrix[i][j] * rgbMatrix[j];
      }
      res[i] = r;
    }

    return res;
  }

}
