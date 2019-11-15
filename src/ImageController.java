import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @program: CS5010-Assignment-7
 * @description:
 * @author: Nan Sun
 * @create: 2019-11-05 21:52
 **/

public class ImageController {

  private ImageModel model;
  private ImageModel originalModel;
  private ImageModel previousModel;

  private ImageView view;

  public ImageController(ImageModel imageModel) {
    this.model = imageModel;
    this.originalModel = imageModel;
    this.previousModel = imageModel;
  }

  //flush the model to the origin
  public void reset() {
    this.model = originalModel;
    this.previousModel = originalModel;
  }

  //Grey
  public void makeGrey() {
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
    model.setBufferedImage(Util.manipulateMatrix(transferMatrix, previousModel.getBufferedImage()));
    previousModel = model;
  }

  //Sepia
  public void makeSepia() {
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
    model.setBufferedImage(Util.manipulateMatrix(transferMatrix, previousModel.getBufferedImage()));
    previousModel = model;
  }

  //Rainbow(create a new image)
  public void makeRainbow(int w, int h, String direction) {
    int mode = -1;
    if (direction == "horizontal") {
      mode = 0;
    } else if (direction == "vertical") {
      mode = 1;
    }
    model.setBufferedImage(Util.drawRainbow(w, h, mode));
  }

  //Checkerboard(create a new image)
  public void makeCheckerboard(int len, int n) {
    model.setBufferedImage(Util.drawCheckerboard(len, n));
  }

  //output
  public void output(String outputPath, String format) throws Exception {
    Util.output(outputPath, format, this.model.getBufferedImage());
  }

}