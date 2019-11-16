import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

  public static BufferedImage dithering(BufferedImage bufferedImage) {
    for (int i = 0; i < bufferedImage.getHeight(); i++) {
      for (int j = 0; j < bufferedImage.getWidth(); j++) {
        int oldC = new Color(bufferedImage.getRGB(i, j)).getRed();

        int newC = oldC > 255 - oldC ? 255 : 0;

        Color newColor = new Color(newC, newC, newC);
        int error = oldC - newC;
        bufferedImage.setRGB(i, j, newColor.getRGB());
        traverseColor(bufferedImage, 7.0 / 16, error, i, j + 1);
        traverseColor(bufferedImage, 3.0 / 16, error, i + 1, j - 1);
        traverseColor(bufferedImage, 5.0 / 16, error, i + 1, j);
        traverseColor(bufferedImage, 1.0 / 16, error, i + 1, j + 1);
      }
    }
    return bufferedImage;
  }

  public static Color colorAdd(double coef, int err, Color c) {
    int newC = (int) (coef * err + c.getRed());
    newC = Math.min(newC, 255);
    newC = Math.max(newC, 0);
    return new Color(newC, newC, newC);
  }

  public static BufferedImage mosaicing(BufferedImage bufferedImage, int seedNum) {
    int[][] seeds = new int[seedNum][2];
    Random random = new Random();
    for (int i = 0; i < seedNum; i++) {
      int[] seed = new int[]{random.nextInt(bufferedImage.getWidth()), random.nextInt(bufferedImage.getHeight())};
      seeds[i] = seed;
    }
    int[][] pixelToSeed = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
    // Find the nearest seed for each pixel.
    for (int i = 0; i < bufferedImage.getWidth(); i++) {
      for (int j = 0; j < bufferedImage.getHeight(); j++) {
        // Traverse all the seeds, and find the nearest one.
        double minDist = Double.MAX_VALUE;
        for (int k = 0; k < seedNum; k++) {
          double curDist = n2Distance(new int[]{i, j}, seeds[k]);
          if (curDist < minDist) {
            minDist = curDist;
            pixelToSeed[i][j] = k;
          }
        }
      }
    }
    // each seed -> corresponding pixels
    List<int[]>[] seedToPixels = new ArrayList[seedNum];
    for (int i = 0; i < seedNum; i++) {
      seedToPixels[i] = new ArrayList<int[]>();
    }
    for (int i = 0; i < bufferedImage.getWidth(); i++) {
      for (int j = 0; j < bufferedImage.getHeight(); j++) {
        int id = pixelToSeed[i][j];
        seedToPixels[id].add(new int[]{i, j});
      }
    }

    // The average color of each seed.
    double[][] seedColor = new double[seedNum][3];
    // Traverse each seed.
    for (int i = 0; i < seedNum; i++) {
      int num = seedToPixels[i].size(); // the number of pixels that belong to the current seed
      for (int j = 0; j < num; j++) {
        Color curColor = new Color(bufferedImage.getRGB(seedToPixels[i].get(j)[0], seedToPixels[i].get(j)[1]));
        seedColor[i][0] += curColor.getRed() / (num + 0.0);
        seedColor[i][1] += curColor.getGreen() / (num + 0.0);
        seedColor[i][2] += curColor.getBlue() / (num + 0.0);
      }
      for (int j = 0; j < num; j++) {
        Color color = new Color((int)seedColor[i][0], (int)seedColor[i][1], (int)seedColor[i][2]);
        int[] pos = seedToPixels[i].get(j);
        bufferedImage.setRGB(pos[0], pos[1], color.getRGB());
      }
    }
    return bufferedImage;
  }

  private static double n2Distance(int[] p1, int[] p2) {
    return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
  }

  public static void traverseColor(BufferedImage bufferedImage, double coef, int error, int X, int Y) {
    if (X >= 0 && X < bufferedImage.getWidth() && Y >= 0 && Y < bufferedImage.getHeight()) {
      Color color = new Color(bufferedImage.getRGB(X, Y));
      Color newColor = colorAdd(coef, error, color);
      bufferedImage.setRGB(X, Y, newColor.getRGB());
    }
  }

  public static void makeGrey(ImageModel model) throws Exception {
    double[][] transferMatrix = new double[3][3];
    transferMatrix[0][0] = 0.2126;
    transferMatrix[0][1] = 0.7152;
    transferMatrix[0][2] = 0.0722;
    transferMatrix[1][0] = 0.2126;
    transferMatrix[1][1] = 0.7152;
    transferMatrix[1][2] = 0.0722;
    transferMatrix[2][0] = 0.2126;
    transferMatrix[2][1] = 0.7152;
    transferMatrix[2][2] = 0.0722;
    model.setBufferedImage(Util.manipulateMatrix(transferMatrix, model.getBufferedImage()));
  }

  //Sepia
  public static void makeSepia(ImageModel model) throws Exception {
    double[][] transferMatrix = new double[3][3];
    transferMatrix[0][0] = 0.393;
    transferMatrix[0][1] = 0.769;
    transferMatrix[0][2] = 0.189;
    transferMatrix[1][0] = 0.349;
    transferMatrix[1][1] = 0.686;
    transferMatrix[1][2] = 0.168;
    transferMatrix[2][0] = 0.272;
    transferMatrix[2][1] = 0.534;
    transferMatrix[2][2] = 0.131;
    model.setBufferedImage(Util.manipulateMatrix(transferMatrix, model.getBufferedImage()));
  }


  public static void saveImage(String filePath, String format, ImageModel imageModel) throws Exception {
    output(filePath,format,imageModel.getBufferedImage());
  }
}