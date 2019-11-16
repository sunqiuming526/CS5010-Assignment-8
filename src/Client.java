import java.io.File;

/**
 * @program: CS5010-Assignment-8
 * @description:
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 16:24
 **/

public class Client {

  public static void main(String[] args) throws Exception {
    String filePath = "test\\image.jpg";
    ImageModel imageModel = null;

    MyController myController = new MyController();
    FileController fileController = new FileController();

    LoadCommand loadCommand = new LoadCommand(filePath);
    fileController.setCommand("load",loadCommand);
    imageModel = fileController.executeCommand("load");

    MakeGreyScaleCommand makeGreyScaleCommand = new MakeGreyScaleCommand(imageModel);
    myController.setCommand("makeGrey",makeGreyScaleCommand);
    myController.executeCommand("makeGrey");

    SaveCommand saveCommand = new SaveCommand("test\\output.png","png",imageModel);
    fileController.setCommand("save",saveCommand);
    fileController.executeCommand("save");
  }


}
