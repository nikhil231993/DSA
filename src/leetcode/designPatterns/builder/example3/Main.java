package leetcode.designPatterns.builder.example3;

public class Main {

    public static void main(String[] args) {
        URLBuilder.Builder builder=new URLBuilder.Builder();
        builder.setProtocol("https://").setDomain("localhost:").setPort("7057").setPathParam("/test").setQueryParam("?v=10");
        URLBuilder urlBuilder=builder.build();

        System.out.print(urlBuilder.getProtocol());
        System.out.print(urlBuilder.getDomain());
        System.out.print(urlBuilder.getPort());
        System.out.print(urlBuilder.getPathParam());
        System.out.println(urlBuilder.getQueryParam());
    }
}
