
/**
 * Class for MakeGreyScaleCommand.
 *
 * @program: CS5010-Assignment-8
 * @description: Class for MakeGreyScaleCommand
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 16:06
 **/
public class MakeGreyScaleCommand implements Command {

  private ImageModel imageModel;

  public MakeGreyScaleCommand(ImageModel imageModel) {
    this.imageModel = imageModel;
  }

  @Override
  public void execute() throws Exception {
    //imageModel.makeGrey()
    Util.makeGrey(imageModel);
  }

  @Override
  public void undo() {
    return;
  }
}
