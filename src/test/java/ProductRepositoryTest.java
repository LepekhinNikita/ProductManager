import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository Repository = new ProductRepository();


    Product Smartphone = new Smartphone(101, "Xiaomi", 10_000, "Китай");
    Product Smartphone1 = new Smartphone(123, "Asus", 27_000, "Тайвань");
    Product Book = new Book(321, "Муха-Цокотуха", 200, "Чуковский");
    Product Book1 = new Book(555, "Евгений Онегин", 300, "Пушкин");

    @BeforeEach
    public void Product() {

        Repository.save(Smartphone);
        Repository.save(Smartphone1);
        Repository.save(Book);
        Repository.save(Book1);

    }
    @Test

    public void shouldSaveProduct() {

        Product[] actual = Repository.getAll();
        Product[] expected = {
                Smartphone,
                Smartphone1,
                Book,
                Book1
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveById() {


        Repository.removeById(321);

        Product[] actual = Repository.getAll();
        Product[] expected = {
                Smartphone,
                Smartphone1,
                Book1,
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByTwoId() {

        Repository.removeById(101);
        Repository.removeById(321);

        Product[] actual = Repository.getAll();
        Product[] expected = {
                Smartphone1,
                Book1,
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllId() {

        Repository.removeById(101);
        Repository.removeById(123);
        Repository.removeById(321);
        Repository.removeById(555);

        Product[] actual = Repository.getAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


}
