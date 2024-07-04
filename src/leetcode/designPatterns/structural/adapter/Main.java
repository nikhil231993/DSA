package leetcode.designPatterns.structural.adapter;

public class Main {

    public static void main(String[] args) {

        String data="xml data";
        JSONAnalyticsToolAdaptee jsonAnalyticsTool=new JSONAnalyticsToolAdaptee();
        jsonAnalyticsTool.setJson(data);
        jsonAnalyticsTool.analyseData();

        XmlToJsonAdapter xmlToJsonAdapter=new XmlToJsonAdapter(data);
        xmlToJsonAdapter.analyseData();
    }
}
