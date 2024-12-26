package leetcode.designPatterns.behaviourial.mediator;

import java.util.ArrayList;
import java.util.List;
public class Mediator {

    private List<Component> componentList=new ArrayList<>();

    public void addComponent(Component component){
        componentList.add(component);
    }

    public void notify(Component component, int amount){

        for(Component comp: componentList){
            if(!comp.equals(component)){
                component.notifyBidValue(amount);
            }
        }
    }
}
