/**
 * Empty Command Class.
 *
 * @program: CS5010-Assignment-8
 * @description: Class for empty command
 * @author: Qiuming Sun + Nan Sun
 * @create: 2019-11-15 16:08
 **/
public class NoCommand implements Command {
  @Override
  public void execute() {
    return;
  }

  @Override
  public void undo() {
    return;
  }
}
