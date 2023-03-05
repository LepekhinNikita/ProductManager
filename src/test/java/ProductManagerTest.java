import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository Repository = new ProductRepository();
    ProductManager Manager = new ProductManager(Repository);

    Product Smartphone = new Smartphone(101, "Xiaomi", 10_000, "Китай");
    Product Smartphone1 = new Smartphone(123, "Asus", 27_000, "Тайвань");
    Product Book = new Book(321, "Муха-Цокотуха", 200, "Чуковский");
    Product Book1 = new Book(555, "Муму", 590, "Тургеньев");

    @BeforeEach
    public void Product() {

        Manager.add(Smartphone);
        Manager.add(Smartphone1);
        Manager.add(Book);
        Manager.add(Book1);


    }


    @Test
    public void shouldFindName() {

        Product[] actual = Manager.searchBy("Xiaomi");
        Product[] expected = {Smartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindName() {

        Product[] actual = Manager.searchBy("Apple");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAnyProducts() {

        Product[] actual = Manager.searchBy("М");
        Product[] expected = {Book, Book1};
        assertArrayEquals(expected, actual);
    }
}