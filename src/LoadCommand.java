

/**
 * @program: CS5010-Assignment-8
 * @description:
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 21:02
 **/
public class LoadCommand implements Command{

  public LoadCommand(String filePath,ImageModel imageModel) {
    ImageModel i = new ImageModel(filePath);
    imageModel.setBufferedImage(i.getBufferedImage());
  }

  @Override
  public void execute() {
    return;
  }

  @Override
  public void undo()
  {
    return;
  }

}
