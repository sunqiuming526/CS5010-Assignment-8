import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @program: CS5010-Assignment-7
 * @description:
 * @author: Nan Sun
 * @create: 2019-11-05 21:53
 **/

public class ImageModel {
  //BufferImage rgb
  private BufferedImage bufferedImage;
  private String path;


  public ImageModel(String path) {
    this.path = path;
    BufferedImage bufferedImage = Util.readFromFile(path);
    this.bufferedImage = bufferedImage;
  }
  public ImageModel(){

  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public void setBufferedImage(BufferedImage bufferedImage) {
    this.bufferedImage = bufferedImage;
  }

}