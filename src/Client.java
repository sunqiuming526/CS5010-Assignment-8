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
    ImageModel imageModel = new ImageModel();

    MyController myController = new MyController();

    LoadCommand loadCommand = new LoadCommand(filePath, imageModel);
    myController.setCommand("load", loadCommand);
    myController.executeCommand("load");

    MakeGreyScaleCommand makeGreyScaleCommand = new MakeGreyScaleCommand(imageModel);
    myController.setCommand("makeGrey", makeGreyScaleCommand);
    myController.executeCommand("makeGrey");

    SaveCommand saveCommand = new SaveCommand("test\\output.png", "png", imageModel);
    myController.setCommand("save", saveCommand);
    myController.executeCommand("save");

    // =======================================================================
    loadCommand = new LoadCommand(filePath, imageModel);
    myController.setCommand("load", loadCommand);
    myController.executeCommand("load");

    MakeDitherCommand makeDitherCommand = new MakeDitherCommand(imageModel);
    myController.setCommand("dither", makeDitherCommand);
    myController.executeCommand("dither");

    saveCommand = new SaveCommand("test\\dither.png", "png", imageModel);
    myController.setCommand("save", saveCommand);
    myController.executeCommand("save");

    // =======================================================================
    loadCommand = new LoadCommand(filePath, imageModel);
    myController.setCommand("load", loadCommand);
    myController.executeCommand("load");

    int seedNum = 5000;
    MakeMosaicCommand makeMosaicCommand = new MakeMosaicCommand(imageModel, seedNum);
    myController.setCommand("mosaic", makeMosaicCommand);
    myController.executeCommand("mosaic");

    saveCommand = new SaveCommand("test\\mosaic.png", "png", imageModel);
    myController.setCommand("save", saveCommand);
    myController.executeCommand("save");

  }


}
