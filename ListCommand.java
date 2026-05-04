package ch.unifr.shopcli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

@Command(name = "list", description = "List products")
public class ListCommand implements Callable<Integer> {

    private final ProductService productService;
    private final ProductFormatter formatter;
    private String lastOutput;

    @Option(names = "--format", description = "Output format: table or json", defaultValue = "table")
    String formatOption;

    public ListCommand() {
        ProductRepository repo = new StaticProductRepository();
        this.productService = new ProductService(repo);
        this.formatter = null;
    }

    public ListCommand(ProductService productService, ProductFormatter formatter) {
        this.productService = productService;
        this.formatter = formatter;
    }

    @Override
    public Integer call() {
        ProductFormatter effectiveFormatter = this.formatter;
        if (effectiveFormatter == null) {
            effectiveFormatter = "json".equalsIgnoreCase(formatOption)
                    ? new JsonProductFormatter()
                    : new TableProductFormatter();
        }

        String output = effectiveFormatter.format(productService.getAllProducts());
        System.out.print(output);
        this.lastOutput = output;
        return 0;
    }

    public String getLastOutput() {
        return lastOutput;
    }
}
