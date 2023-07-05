import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void addingBooks() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Pride and Prejudice", 1300, "Jane Austen");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searching() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Pride and Prejudice", 1300, "Jane Austen");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Flowers");

        Assertions.assertArrayEquals(expected, actual);
    }
}