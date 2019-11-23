/**
 * Class for MakeMosaicCommand.
 *
 * @program: CS5010-Assignment-8
 * @description: Class for MakeMosaicCommand
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 20:59
 */
public class MakeMosaicCommand implements Command {

  ImageModel imageModel;
  int seedNum;

  public MakeMosaicCommand(ImageModel imageModel, int seedNum) {
    this.imageModel = imageModel;
    this.seedNum = seedNum;
  }

  @Override
  public void execute() throws Exception {
    Util.mosaicing(imageModel, seedNum);
  }

  @Override
  public void undo() {
    return;
  }
}
