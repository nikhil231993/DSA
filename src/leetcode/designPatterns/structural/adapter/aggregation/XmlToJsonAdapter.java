package leetcode.designPatterns.structural.adapter.aggregation;

public class XmlToJsonAdapter implements Adapter {

    private JSONAnalyticsToolAdaptee jsonAnalyticsToolAdaptee;

    public XmlToJsonAdapter(String data, JSONAnalyticsToolAdaptee jsonAnalyticsToolAdaptee){

        //Conversion can happen anywhere in this class
        System.out.println("Converting the XML Data '" + data + "' to JSON Data!");
        String newData = data + " in json";
        this.jsonAnalyticsToolAdaptee=jsonAnalyticsToolAdaptee;
        this.jsonAnalyticsToolAdaptee.setJson(newData);
    }

    @Override
    public void analyseData() {
        this.jsonAnalyticsToolAdaptee.analyseData();
    }
}
