

/**
 * @program: CS5010-Assignment-8
 * @description:
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 21:03
 **/
public class SaveCommand implements Command2 {

  private String filePath;
  private String format;
  private ImageModel imageModel;

  public SaveCommand(String filePath, String format,ImageModel imageModel) {
    this.filePath = filePath;
    this.format = format;
    this.imageModel = imageModel;
  }

  @Override
  public ImageModel execute() throws Exception {
   Util.saveImage(filePath,format,imageModel);
   return imageModel;
  }

  @Override
  public ImageModel undo() {
    return null;
  }
}
