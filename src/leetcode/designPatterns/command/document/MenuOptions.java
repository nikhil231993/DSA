package leetcode.designPatterns.command.document;

import java.util.ArrayList;
import java.util.List;

public class MenuOptions {

    //Invoker
    private List<Command> commands=new ArrayList<>();

    public void addCommands(Command command){
        commands.add(command);
    }

    public void executeCommands(){
        for(Command cmd: commands){
            cmd.execute();
        }
    }
}
