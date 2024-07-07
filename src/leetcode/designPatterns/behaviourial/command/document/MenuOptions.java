package leetcode.designPatterns.behaviourial.command.document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MenuOptions {

    //Invoker
    private List<Command> commands=new ArrayList<>();

    private Stack<Command> undoCommands=new Stack<>();

    public void addCommands(Command command){
        commands.add(command);
    }

    public void executeCommands(){
        for(Command cmd: commands){
            undoCommands.push(cmd);
            cmd.execute();
        }
        commands.clear();
    }

    public void executeUndoCommands(){
        while(!undoCommands.isEmpty()){
            Command cmd= undoCommands.pop();
            cmd.executeUndo();
        }
    }
}
