import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @program: CS5010-Assignment-7
 * @description:
 * @author: Nan Sun
 * @create: 2019-11-05 21:51
 **/

public class Util {
  public static final int HORIZONTAL = 0;
  public static final int VERTICAL = 1;


  public static void output(String outputPath, String format, BufferedImage bufferedImage) throws Exception {
    File f = new File(outputPath);
    ImageIO.write(bufferedImage, format, f);
  }

  public static BufferedImage readFromFile(String path) {
    File file = new File(path);
    BufferedImage bufferedImage = null;
    try {
      bufferedImage = ImageIO.read(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return bufferedImage;
  }

  public static BufferedImage manipulateMatrix(double[][] transferMatrix, BufferedImage bufferedImage) {

    int width = bufferedImage.getWidth();
    int height = bufferedImage.getHeight();
    int minx = bufferedImage.getMinX();
    int miny = bufferedImage.getMinY();

    int[] rgb = new int[3];
    for (int i = minx; i < width; i++) {
      for (int j = miny; j < height; j++) {
        int pixel = bufferedImage.getRGB(i, j);

        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);

        int[] res = matrix(transferMatrix, rgb);
        for (int k = 0; k < 3; k++) {
          if (res[k] < 0) {
            res[k] = 0;
          }
          if (res[k] > 255) {
            res[k] = 255;
          }
        }
        bufferedImage.setRGB(i, j, new Color(res[0], res[1], res[2]).getRGB());

      }
    }

    return bufferedImage;
  }

  // 3 * 3
  public static int[] matrix(double[][] transMatrix, int[] rgbMatrix) {
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

  public static BufferedImage generateBufferedImage(int width, int height, Color color) {
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException("Wrong picture size");
    }
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    int myColor = color.getRGB();

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        bufferedImage.setRGB(i, j, myColor);
      }
    }
    return bufferedImage;
  }

  public static void generateStripe(BufferedImage bufferedImage,
                                    int wStart, int wEnd,
                                    int hStart, int hEnd,
                                    Color color) {
    if (hStart < 0 || wStart < 0
        || hEnd > bufferedImage.getHeight() || wEnd > bufferedImage.getWidth()) {
      throw new IllegalArgumentException("Wrong picture size");
    }

    int colorRGB = color.getRGB();

    for (int i = wStart; i < wEnd; i++) {
      for (int j = hStart; j < hEnd; j++) {
        bufferedImage.setRGB(i, j, colorRGB);
      }
    }
  }

  public static BufferedImage drawRainbow(int width, int height, int mode) {
    int length;
    if (mode == Util.HORIZONTAL) {
      length = height;
    } else if (mode == Util.VERTICAL) {
      length = width;
    } else {
      throw new IllegalArgumentException("Direction has to be either horizontal or vertical.");
    }

    Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, new Color(128, 0, 128)};
    int unit = length % 7 == 0 ? length / 7 : length / 7 + 1;
    int[] units = new int[7];
    for (int i = 0; i < 6; i++) {
      units[i] = unit;
    }
    units[6] = length - 6 * unit;

    BufferedImage bufferedImage = generateBufferedImage(width, height, new Color(255, 255, 255));

    if (mode == Util.HORIZONTAL) {
      int hStart = 0;
      for (int i = 0; i < 7; i++) {
        generateStripe(bufferedImage, 0, width, hStart, hStart + units[i], colors[i]);
        hStart += units[i];
      }
    } else if (mode == Util.VERTICAL) {
      int wStart = 0;
      for (int i = 0; i < 7; i++) {
        generateStripe(bufferedImage, wStart, wStart + units[i], 0, height, colors[i]);
        wStart += units[i];
      }
    }

    return bufferedImage;
  }

  public static BufferedImage drawCheckerboard(int len, int n) {
    BufferedImage bufferedImage = generateBufferedImage(len, len, new Color(255, 255, 255));

    int black = new Color(0, 0, 0).getRGB();

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if ((i / n) % 2 == 0) {
          if ((j / n) % 2 == 1) {
            bufferedImage.setRGB(i, j, black);
          }
        } else {
          if ((j / n) % 2 == 0) {
            bufferedImage.setRGB(i, j, black);
          }
        }
      }
    }

    return bufferedImage;
  }

}