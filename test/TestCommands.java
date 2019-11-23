import org.junit.Test;

import java.io.File;

import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * Test for batch commands.
 */
public class TestCommands {
  @Test
  public void testSingleCommand() throws Exception {
    String filePath = "test/single_command.txt";
    File input = new File(filePath);
    Scanner scanner = new Scanner(input);
    boolean completed = false;
    // Initialize the controller and the image model
    ImageModel imageModel = new ImageModel();
    MyController myController = new MyController();

    // Read each line of the command input
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] paras = line.split(" ");
      BatchCommand.driver(paras, myController, imageModel);
    }
    completed = true;
    assertTrue(completed);
  }

  @Test
  public void testCombinedCommand() throws Exception {
    String filePath = "test/combined_command.txt";
    File input = new File(filePath);
    Scanner scanner = new Scanner(input);
    boolean completed = false;

    // Initialize the controller and the image model
    ImageModel imageModel = new ImageModel();
    MyController myController = new MyController();

    // Read each line of the command input
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] paras = line.split(" ");
      BatchCommand.driver(paras, myController, imageModel);
    }
    completed = true;
    assertTrue(completed);
  }

  @Test
  public void testEmptyCommand() throws Exception {
    String filePath = "test/empty_command.txt";
    File input = new File(filePath);
    Scanner scanner = new Scanner(input);
    boolean completed = false;

    // Initialize the controller and the image model
    ImageModel imageModel = new ImageModel();
    MyController myController = new MyController();

    // Read each line of the command input
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] paras = line.split(" ");
      BatchCommand.driver(paras, myController, imageModel);
    }
    completed = true;
    assertTrue(completed);
  }

  @Test(expected = Exception.class)
  public void testInvalidImagePath() throws Exception {
    String filePath = "test/invalid_image_path_command.txt";
    File input = new File(filePath);
    Scanner scanner = new Scanner(input);

    // Initialize the controller and the image model
    ImageModel imageModel = new ImageModel();
    MyController myController = new MyController();

    // Read each line of the command input
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] paras = line.split(" ");
      BatchCommand.driver(paras, myController, imageModel);
    }
  }

  @Test(expected = Exception.class)
  public void testNoLoadingImage() throws Exception {
    String filePath = "test/no_loading_image_command.txt";
    File input = new File(filePath);
    Scanner scanner = new Scanner(input);

    // Initialize the controller and the image model
    ImageModel imageModel = new ImageModel();
    MyController myController = new MyController();

    // Read each line of the command input
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] paras = line.split(" ");
      BatchCommand.driver(paras, myController, imageModel);
    }
  }
}
