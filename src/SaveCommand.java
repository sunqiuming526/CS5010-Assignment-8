

/**
 * @program: CS5010-Assignment-8
 * @description:
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 21:03
 **/
public class SaveCommand implements Command {

  private String filePath;
  private String format;
  private ImageModel imageModel;

  public SaveCommand(String filePath, String format,ImageModel imageModel) {
    this.filePath = filePath;
    this.format = format;
    this.imageModel = imageModel;
  }

  @Override
  public void execute() throws Exception {
    Util.saveImage(filePath,format,imageModel);
  }

  @Override
  public void undo() {

  }
}
