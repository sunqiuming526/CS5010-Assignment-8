import java.io.File;
import java.util.Scanner;

/**
 * Batch Command Class.
 */
public class BatchCommand {

  /**
   * main function for reading the command.
   *
   * @param args the arguments
   * @throws Exception raise an error when the input file has errors
   */
  public static void main(String[] args) throws Exception {
    String filePath = args[0];
    File input = new File(filePath);
    Scanner scanner = new Scanner(input);

    // Initialize the controller and the image model
    ImageModel imageModel = new ImageModel();
    MyController myController = new MyController();

    // Read each line of the command input
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] paras = line.split(" ");
      driver(paras, myController, imageModel);
    }
  }

  /**
   * Pass the command parameters to the controller.
   *
   * @param paras        command parameters
   * @param myController controller
   * @param imageModel   image model
   * @throws Exception raise exception when command is invalid
   */
  public static void driver(String[] paras, MyController myController, ImageModel imageModel)
          throws Exception {
    String command = paras[0];
    String filePath;

    switch (command) {
      case "load":
        filePath = paras[1];
        LoadCommand loadCommand = new LoadCommand(filePath, imageModel);
        myController.setCommand("load", loadCommand);
        myController.executeCommand("load");
        break;
      case "save":
        Util.checkImageModelNull(imageModel); // if imageModel is null, raise an error
        filePath = paras[1];
        SaveCommand saveCommand = new SaveCommand(filePath, "png", imageModel);
        myController.setCommand("save", saveCommand);
        myController.executeCommand("save");
        break;
      case "dither":
        Util.checkImageModelNull(imageModel);
        MakeDitherCommand makeDitherCommand = new MakeDitherCommand(imageModel);
        myController.setCommand("dither", makeDitherCommand);
        myController.executeCommand("dither");
        break;
      case "mosaic":
        Util.checkImageModelNull(imageModel);
        int seedNum = Integer.parseInt(paras[1]);
        MakeMosaicCommand makeMosaicCommand = new MakeMosaicCommand(imageModel, seedNum);
        myController.setCommand("mosaic", makeMosaicCommand);
        myController.executeCommand("mosaic");
        break;
      case "grey":
        Util.checkImageModelNull(imageModel);
        MakeGreyScaleCommand makeGreyScaleCommand = new MakeGreyScaleCommand(imageModel);
        myController.setCommand("makeGrey", makeGreyScaleCommand);
        myController.executeCommand("makeGrey");
        break;
      case "sepia":
        Util.checkImageModelNull(imageModel);
        MakeSepiaCommand makeSepiaCommand = new MakeSepiaCommand(imageModel);
        myController.setCommand("makeSepia", makeSepiaCommand);
        myController.executeCommand("makeSepia");
        break;
      default:
        throw new IllegalArgumentException("Invalid Command: " + command);
    }

  }


}
