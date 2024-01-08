package leetcode.designPatterns.adapter;

public class Main {

    public static void main(String[] args) {
        String data="xml data";
        JSONAnalyticsTool jsonAnalyticsTool=new JSONAnalyticsTool();
        jsonAnalyticsTool.setJson(data);
        jsonAnalyticsTool.analyseData();

        XmlToJsonAdapter xmlToJsonAdapter=new XmlToJsonAdapter(data);
        xmlToJsonAdapter.analyseData();
    }
}
