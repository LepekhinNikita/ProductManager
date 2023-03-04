public class ProductRepository {

    protected Product[] prod = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[prod.length + 1];
        for (int i = 0; i < prod.length; i++) {
            tmp[i] = prod[i];
        }
        tmp[tmp.length - 1] = product;
        prod = tmp;
    }

    public Product[] getAll() {
        return prod;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[prod.length - 1];
        int copyToIndex = 0;
        for (Product prod : prod) {
            if (prod.getId() != id) {
                tmp[copyToIndex] = prod;
                copyToIndex++;
            }
        }
        prod = tmp;
    }
}