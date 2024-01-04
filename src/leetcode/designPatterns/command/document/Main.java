package leetcode.designPatterns.command.document;

public class Main {

    public static void main(String[] args) {

        Document doc=new Document();

        Command open=new OpenCommand(doc);
        Command save=new SaveCommand(doc);

        MenuOptions menu=new MenuOptions();
        menu.addCommands(open);
        menu.addCommands(save);

        menu.executeCommands();
    }
}
