// ProductController.java
package product;

import java.util.ArrayList;
import exceptions.NegativePriceException;
import exceptions.NotFoundException;

public class ProductController {
    private ArrayList<ProductModel> products;

    public ProductController() {
        this.products = new ArrayList<>();
    }

    public String create(ProductModel payload) {
        if (payload.getPriceInCents() < 0) {
            throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
        }

        this.products.add(payload);
        return "Produto '" + payload.getName() + "' adicionado.";
    }

    public ArrayList<ProductModel> read() {
        return this.products;
    }

    public int retrievePrice(String barCode) throws NotFoundException {
        for (ProductModel product : products) {
            if (product.getBarCode().equals(barCode)) {
                return product.getPriceInCents();
            }
        }
        throw new NotFoundException("Product '" + barCode + "' not found.");
    }
}
