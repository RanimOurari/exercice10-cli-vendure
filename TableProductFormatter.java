package ch.unifr.shopcli;

import java.util.List;

public class TableProductFormatter implements ProductFormatter {

    @Override
    public String format(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-20s %-10s%n", "ID", "Name", "Price"));
        sb.append("---------------------------------------------\n");
        for (Product p : products) {
            sb.append(String.format("%-10s %-20s %-10.2f%n",
                    p.getId(), p.getName(), p.getPrice()));
        }
        return sb.toString();
    }
}
