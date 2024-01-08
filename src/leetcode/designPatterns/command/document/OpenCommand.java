package leetcode.designPatterns.command.document;

public class OpenCommand implements Command {

    private Document document;

    public OpenCommand(Document document){
        this.document=document;
    }

    @Override
    public void execute() {
        document.open();
    }
}
