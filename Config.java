package ch.unifr.shopcli;

public class Config {

    private final String url;

    private Config(String url) {
        this.url = url;
    }

    public static Config fromArgsAndEnv(String optionUrl, String envUrl) {
        if (optionUrl != null && !optionUrl.isBlank()) return new Config(optionUrl);
        if (envUrl != null && !envUrl.isBlank()) return new Config(envUrl);
        return new Config("http://localhost:3000/shop-api");
    }

    public String getUrl() {
        return url;
    }
}
