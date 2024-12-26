package leetcode.designPatterns.behaviourial.state;

public class StateController {

    State state;

    public StateController(){
        state=new IdleState();
    }

    public void setState(State state){
        this.state=state;
    }

    public State getState(){
        return this.state;
    }
}
