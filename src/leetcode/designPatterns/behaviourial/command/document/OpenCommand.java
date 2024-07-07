package leetcode.designPatterns.behaviourial.command.document;

public class OpenCommand implements Command {

    private Document document;

    public OpenCommand(Document document){
        this.document=document;
    }

    @Override
    public void execute() {
        document.open();
    }

    @Override
    public void executeUndo() {
        document.save();
    }
}
