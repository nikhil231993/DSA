package leetcode.designPatterns.builder.example2;

public class URLBuilder {

    public final String protocol;
    public final String domain;
    public final String port;
    public final String pathParam;
    public final String queryParam;

    private URLBuilder(Builder builder){
        this.protocol=builder.protocol;
        this.domain=builder.domain;
        this.port=builder.port;
        this.pathParam=builder.pathParam;
        this.queryParam=builder.queryParam;
    }

    public static class Builder{

        private String protocol;
        private String domain;
        private String port;
        private String pathParam;
        private String queryParam;

        public URLBuilder build(){
            return new URLBuilder(this);
        }

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
    }
}
