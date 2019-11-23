/**
 * The interface for Command.
 */
public interface Command {
  public void execute() throws Exception;

  public void undo();
}
