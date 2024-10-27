package leetcode.designPatterns.creational.builder.example4UsingInnerClass;

public class URL {

    private final String protocol;

    private final String domain;

    private final String port;

    private final String pathParam;

    private final String queryParam;

    private URL(Builder builder){

        this.protocol=builder.protocol;
        this.domain=builder.domain;
        this.port=builder.port;
        this.pathParam=builder.pathParam;
        this.queryParam=builder.queryParam;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDomain() {
        return domain;
    }

    public String getPort() {
        return port;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public static class Builder{

        private String protocol;
        private String domain;
        private String port;
        private String pathParam;
        private String queryParam;

        public Builder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setPort(String port) {
            this.port = port;
            return this;
        }

        public Builder setPathParam(String pathParam) {
            this.pathParam = pathParam;
            return this;
        }

        public Builder setQueryParam(String queryParam) {
            this.queryParam = queryParam;
            return this;
        }

        public URL build(){
            return new URL(this);
        }
    }
}
