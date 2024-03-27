import exceptions.NotFoundException;
import product.ProductController;
import product.ProductModel;

public class Main {
    public static void main(String[] args) {
        // Exemplo de utilização
        ProductController controller = new ProductController();

        // Criando produtos
        ProductModel product1 = new ProductModel();
        product1.setBarCode("123456789");
        product1.setName("Produto 1");
        product1.setPriceInCents(100);
        product1.setStock(10);

        ProductModel product2 = new ProductModel();
        product2.setBarCode("987654321");
        product2.setName("Produto 2");
        product2.setPriceInCents(150);
        product2.setStock(5);

        // Adicionando produtos
        System.out.println(controller.create(product1));
        System.out.println(controller.create(product2));

        // Listando produtos
        System.out.println("Produtos disponíveis:");
        for (ProductModel product : controller.read()) {
            System.out.println(product.getName() + " - Preço: " + product.getPriceInCents() + " centavos");
        }

        // Buscando preço por código de barras
        try {
            int price = controller.retrievePrice("123456789");
            System.out.println("Preço do Produto 1: " + price + " centavos");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
