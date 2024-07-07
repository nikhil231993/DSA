package leetcode.designPatterns.structural.adapter.aggregation;

public class Main {

    public static void main(String[] args) {

        //aggregation because we create adaptee object in client and then pass it.
        String data="xml data";
        JSONAnalyticsToolAdaptee jsonAnalyticsTool=new JSONAnalyticsToolAdaptee();
        jsonAnalyticsTool.setJson(data);
        jsonAnalyticsTool.analyseData();

        XmlToJsonAdapter xmlToJsonAdapter=new XmlToJsonAdapter(data, new JSONAnalyticsToolAdaptee());
        xmlToJsonAdapter.analyseData();
    }
}
