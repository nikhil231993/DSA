package leetcode.designPatterns.adapter;

public class XmlToJsonAdapter  implements  adapter{

    private JSONAnalyticsTool jsonAnalyticsTool;

    public XmlToJsonAdapter(String data){
        System.out.println("Converting the XML Data '" + data + "' to JSON Data!");
        String newData = data + " in json";
        jsonAnalyticsTool=new JSONAnalyticsTool();
        jsonAnalyticsTool.setJson(newData);
    }

    @Override
    public void analyseData() {
        jsonAnalyticsTool.analyseData();
    }
}
