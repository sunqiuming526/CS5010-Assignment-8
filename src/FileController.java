import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: CS5010-Assignment-8
 * @description:
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 22:04
 **/
public class FileController {
  private List<String> commandHistory ;
  private Map<String,Command2> commandMap ;
  //undo
  private Command undo;

  public FileController() {
    this.commandHistory = new ArrayList<>();
    this.commandMap = new HashMap<>();
  }

  public void setCommand(String commandName, Command2 command2) {
    commandMap.put(commandName,command2);
  }

  public ImageModel executeCommand(String commandName) throws Exception {

    if(commandMap.containsKey(commandName)) {

      commandHistory.add(commandName);
      return commandMap.get(commandName).execute();
    }
    else{
      throw new IllegalArgumentException("No such Command");
    }
  }
}
