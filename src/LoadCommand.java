

/**
 * @program: CS5010-Assignment-8
 * @description:
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 21:02
 **/
public class LoadCommand implements Command{

  public LoadCommand(String filePath,ImageModel imageModel) {
    imageModel = Util.loadImage(filePath);
  }

  @Override
  public void execute() throws Exception {

  }

  @Override
  public void undo() {

  }
}
