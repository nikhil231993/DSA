package leetcode.designPatterns.structural.adapter.aggregation;

public class AdapterXmlToJson implements Adapter {

    private JSONAnalyticsToolAdaptee jsonAnalyticsToolAdaptee;

    public AdapterXmlToJson(String data, JSONAnalyticsToolAdaptee jsonAnalyticsToolAdaptee){

        //Conversion can happen anywhere in this class
        System.out.println("Converting the XML Data '" + data + "' to JSON Data!");
        String newData = data + " in json";
        this.jsonAnalyticsToolAdaptee=jsonAnalyticsToolAdaptee;
        this.jsonAnalyticsToolAdaptee.setJson(newData); // This method cannot be present in Adaptee as Adaptee is external library and
        // we are trying modify our code to handle the external old format of the code
        //So we can convert xmlToJson in this class itself
    }

    @Override
    public void analyseData() {
        this.jsonAnalyticsToolAdaptee.analyseData();
    }
}
