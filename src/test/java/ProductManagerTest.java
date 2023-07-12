import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void addingBooks() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Sun and Her Flowers", 1300, "Rupi Kaur");
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
    public void searchingFirstBookByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Sun and Her Flowers", 1300, "Rupi Kaur");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("The Sun and Her Flowers");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingThirdBookByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Sun and Her Flowers", 1300, "Rupi Kaur");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Algernon");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingSecondBookByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Sun and Her Flowers", 1300, "Rupi Kaur");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("The Great Gatsby");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingNotExistingBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Sun and Her Flowers", 1300, "Rupi Kaur");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("The little prince");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingTwoBooks() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "The Sun and Her Flowers", 1300, "Rupi Kaur");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Flowers");

        Assertions.assertArrayEquals(expected, actual);
    }
}
