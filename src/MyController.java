import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for MyController.
 *
 * @program: CS5010-Assignment-8
 * @description: controller class
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 16:14
 **/
public class MyController {
  private List<String> commandHistory;
  private Map<String, Command> commandMap;
  //undo
  private Command undo;

  /**
   * The constructor function for MyController.
   */
  public MyController() {
    this.commandHistory = new ArrayList<>();
    this.commandMap = new HashMap<>();
  }

  /**
   * Set the command.
   *
   * @param commandName String of the command name
   * @param command     the command
   */
  public void setCommand(String commandName, Command command) {
    commandMap.put(commandName, command);
  }

  /**
   * Execute the command.
   *
   * @param commandName String of the command name
   * @throws Exception Raise an error when the command name is invalid
   */
  public void executeCommand(String commandName) throws Exception {

    if (commandMap.containsKey(commandName)) {
      commandMap.get(commandName).execute();
      commandHistory.add(commandName);
    } else {
      throw new IllegalArgumentException("No such Command");
    }
  }


}