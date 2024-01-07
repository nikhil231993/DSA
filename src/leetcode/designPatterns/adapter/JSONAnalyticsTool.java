package leetcode.designPatterns.adapter;

public class JSONAnalyticsTool {

    //Adaptee
    private String data;

    public void setJson(String data){
        this.data=data;
    }

    public void analyseData(){
        if(data.contains("json")){
            System.out.println("Analysing Json Data :" +data);
        }else{
            System.out.println("Not in the correct format. Cannot analyse data");
        }
    }
}
