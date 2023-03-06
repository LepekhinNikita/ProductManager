import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product Smartphone = new Smartphone(101, "Xiaomi", 10_000, "Китай");
    Product Smartphone1 = new Smartphone(123, "Asus", 27_000, "Тайвань");
    Product Book = new Book(321, "Муха-Цокотуха", 200, "Чуковский");
    Product Book1 = new Book(555, "Муму", 590, "Тургеньев");

    @BeforeEach
    public void Product() {

        manager.add(Smartphone);
        manager.add(Smartphone1);
        manager.add(Book);
        manager.add(Book1);


    }


    @Test
    public void shouldFindName() {

        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = {Smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindName() {

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAnyProducts() {

        Product[] actual = manager.searchBy("М");
        Product[] expected = {Book, Book1};
        assertArrayEquals(expected, actual);
    }
}