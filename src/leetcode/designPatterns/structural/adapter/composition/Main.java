package leetcode.designPatterns.structural.adapter.composition;

public class Main {

    public static void main(String[] args) {

        //Composition because we create adaptee object in adapter.
        String data="xml data";
        JSONAnalyticsToolAdaptee jsonAnalyticsTool=new JSONAnalyticsToolAdaptee();
        jsonAnalyticsTool.setJson(data);
        jsonAnalyticsTool.analyseData();

        XmlToJsonAdapter xmlToJsonAdapter=new XmlToJsonAdapter(data);
        xmlToJsonAdapter.analyseData();
    }
}
