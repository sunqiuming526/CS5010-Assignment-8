

/**
 * @program: CS5010-Assignment-8
 * @description:
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 21:02
 **/
public class LoadCommand implements Command2{

  ImageModel imageModel;

  public LoadCommand(String filePath) {
    this.imageModel = new ImageModel(filePath);
  }

  @Override
  public ImageModel execute() {
    return this.imageModel;
  }

  @Override
  public ImageModel undo()
  {
    return null;
  }

}
