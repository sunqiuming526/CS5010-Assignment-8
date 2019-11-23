import java.awt.image.BufferedImage;

/**
 * Class for ImageModel.
 *
 * @program: CS5010-Assignment-7
 * @description: Class for ImageModel
 * @author: Nan Sun
 * @create: 2019-11-05 21:53
 **/

public class ImageModel {
  //BufferImage rgb
  private BufferedImage bufferedImage;

  public ImageModel(String path) {
    this.bufferedImage = Util.readFromFile(path);
  }

  public ImageModel() {
    // Empty Constructor: leave the bufferedImage Null.
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public void setBufferedImage(BufferedImage bufferedImage) {
    this.bufferedImage = bufferedImage;
  }

}