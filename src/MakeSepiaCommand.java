
/**
 * Class for MakeSepiaCommand.
 *
 * @program: CS5010-Assignment-8
 * @description: Class for MakeSepiaCommand
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 20:59
 **/
public class MakeSepiaCommand implements Command {

  private ImageModel imageModel;

  public MakeSepiaCommand(ImageModel imageModel) {
    this.imageModel = imageModel;
  }

  @Override
  public void execute() throws Exception {
    //imageModel.makeSepia()
    Util.makeSepia(imageModel);
  }

  @Override
  public void undo() {
    return;
  }
}
