package leetcode.designPatterns.behaviourial.command.document;

public class Main {

    public static void main(String[] args) {

        //The difference of this with strategy DP is that here we can do undo as well
        //https://github.com/ashishps1/awesome-low-level-design/blob/main/design-patterns/java/command/RemoteControlWithUndo.java

        Document doc=new Document();

        Command open=new OpenCommand(doc);
        Command save=new SaveCommand(doc);

        MenuOptions menu=new MenuOptions();
        menu.addCommands(open);
        menu.addCommands(save);

        menu.executeCommands();
    }
}
