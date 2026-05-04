package ch.unifr.shopcli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "cli",
        mixinStandardHelpOptions = true,
        description = "Shop CLI for listing products",
        subcommands = { ListCommand.class }
)
public class App implements Runnable {

    @Option(names = "--url", description = "Vendure shop API URL")
    String urlOption;

    private Config config;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        String envUrl = System.getenv("URL");
        this.config = Config.fromArgsAndEnv(urlOption, envUrl);
        System.out.println("Using Vendure URL: " + config.getUrl());
    }
}
