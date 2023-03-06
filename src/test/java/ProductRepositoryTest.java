import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();


    Product Smartphone = new Smartphone(101, "Xiaomi", 10_000, "Китай");
    Product Smartphone1 = new Smartphone(123, "Asus", 27_000, "Тайвань");
    Product Book = new Book(321, "Муха-Цокотуха", 200, "Чуковский");
    Product Book1 = new Book(555, "Евгений Онегин", 300, "Пушкин");
    Product Book2 = new Book(999, "Колобок", 100, "Руские народные сказки");

    @BeforeEach
    public void Product() {

        repository.save(Smartphone);
        repository.save(Smartphone1);
        repository.save(Book);
        repository.save(Book1);

    }
    @Test

    public void shouldSaveProduct() {

        Product[] actual = repository.getAll();
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


        repository.removeById(321);

        Product[] actual = repository.getAll();
        Product[] expected = {
                Smartphone,
                Smartphone1,
                Book1,
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByTwoId() {

        repository.removeById(101);
        repository.removeById(321);

        Product[] actual = repository.getAll();
        Product[] expected = {
                Smartphone1,
                Book1,
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllId() {

        repository.removeById(101);
        repository.removeById(123);
        repository.removeById(321);
        repository.removeById(555);

        Product[] actual = repository.getAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveByIdWitchIsNot() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(777);
        });
    }
    @Test

    public void shouldRemoveByIdNew() {


        repository.removeById(555);

        Product[] actual = repository.getAll();
        Product[] expected = {
                Smartphone,
                Smartphone1,
                Book,
        };

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldSaveProductNew() {
        repository.save(Book2);

        Product[] actual = repository.getAll();
        Product[] expected = {
                Smartphone,
                Smartphone1,
                Book,
                Book1,
                Book2
        };
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.save(Book2);
        });
    }
}
