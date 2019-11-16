
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

    LoadCommand loadCommand = new LoadCommand(filePath);

    myController.setCommand("load",loadCommand);
    myController.executeCommand("load");

    MakeGreyScaleCommand makeGreyScaleCommand = new MakeGreyScaleCommand(imageModel);
    myController.setCommand("makeGrey",makeGreyScaleCommand);
    myController.executeCommand("makeGrey");

  }


}
