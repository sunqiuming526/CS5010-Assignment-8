/**
 * Class for MakeDitherCommand.
 *
 * @program: CS5010-Assignment-8
 * @description: Class for MakeDitherCommand
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 16:06
 **/

public class MakeDitherCommand implements Command {
  ImageModel imageModel;

  public MakeDitherCommand(ImageModel imageModel) {
    this.imageModel = imageModel;
  }

  @Override
  public void execute() throws Exception {
    Util.dithering(imageModel);
  }

  @Override
  public void undo() {
    return;
  }
}
