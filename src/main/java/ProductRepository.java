public class ProductRepository {

    protected Product[] prod = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[prod.length + 1];
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException("ID already exists ");
        }
        for (int i = 0; i < prod.length; i++) {
            tmp[i] = prod[i];
        }
        tmp[tmp.length - 1] = product;
        prod = tmp;
    }


    public Product[] getAll() {
        return prod;
    }

    public Product findById(int id) {
        for (Product prod : prod) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
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