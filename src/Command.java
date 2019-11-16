public interface Command {
  public void execute() throws Exception;
  public void undo();
}
