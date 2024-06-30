package leetcode.designPatterns.builder.example4;

public class Main {

    public static void main(String[] args) {

        URL.Builder builder=new URL.Builder();
        builder.setProtocol("https://").setDomain("localhost:").setPort("7057").setPathParam("/test").setQueryParam("?v=10");
        URL url=builder.build();

        System.out.print(url.getProtocol());
        System.out.print(url.getDomain());
        System.out.print(url.getPort());
        System.out.print(url.getPathParam());
        System.out.println(url.getQueryParam());
    }
}
