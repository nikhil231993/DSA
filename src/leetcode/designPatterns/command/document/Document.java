package leetcode.designPatterns.command.document;

public class Document {

    //This is the receiver
    public void open(){
        System.out.println("Document open");
    }

    public void save(){
        System.out.println("Document save");
    }
}
