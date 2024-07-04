package leetcode.designPatterns.structural.adapter;

public class XmlToJsonAdapter implements Adapter {

    private JSONAnalyticsToolAdaptee jsonAnalyticsToolAdaptee;

    public XmlToJsonAdapter(String data){

        //Conversion can happen anywhere in this class
        System.out.println("Converting the XML Data '" + data + "' to JSON Data!");
        String newData = data + " in json";
        jsonAnalyticsToolAdaptee=new JSONAnalyticsToolAdaptee();
        jsonAnalyticsToolAdaptee.setJson(newData);
    }

    @Override
    public void analyseData() {
        jsonAnalyticsToolAdaptee.analyseData();
    }
}
