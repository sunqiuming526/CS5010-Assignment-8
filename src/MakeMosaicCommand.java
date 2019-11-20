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
    //do nothing temporarily

  }
}
