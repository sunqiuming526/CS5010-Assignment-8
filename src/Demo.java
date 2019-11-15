import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @program: CS5010-Assignment-7
 * @description:
 * @author: Nan Sun
 * @create: 2019-11-06 16:59
 **/

public class Demo {

  public static void main(String[] args) throws Exception {

    String filePath = "test\\image.jpg";
    ImageModel imageModel = new ImageModel(filePath);
    ImageController imageController = new ImageController(imageModel);

    String newFilePath1 = "test\\res1.png";
    String format1 = "png";
    imageController.makeGrey();
    imageController.output(newFilePath1,format1);

    imageController.reset();

    String newFilePath2 = "test\\res2.png";
    String format2 = "png";
    imageController.makeSepia();
    imageController.output(newFilePath2,format2);

    imageController.reset();

    String newFilePath3 = "test\\res3.png";
    imageController.makeCheckerboard(1000,23);
    imageController.output(newFilePath3,"png");


  }

}
