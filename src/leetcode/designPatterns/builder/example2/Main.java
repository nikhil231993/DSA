package leetcode.designPatterns.builder.example2;

public class Main {

    public static void main(String[] args) {
        URLBuilder.Builder builder=new URLBuilder.Builder();
        builder.setProtocol("https://").setDomain("localhost:").setPort("7057").setPathParam("/test").setQueryParam("?v=10");
        URLBuilder urlBuilder=builder.build();

        System.out.print(urlBuilder.protocol);
        System.out.print(urlBuilder.domain);
        System.out.print(urlBuilder.port);
        System.out.print(urlBuilder.pathParam);
        System.out.println(urlBuilder.queryParam);
    }
}
