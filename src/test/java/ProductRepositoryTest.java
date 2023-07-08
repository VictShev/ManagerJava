import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {


    @Test
    public void removingExistingFirstBook() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "Pride and Prejudice", 1300, "Jane Austen");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.removeId(1);

        Product[] expected = {book2, book3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removingExistingSecondBook() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "Pride and Prejudice", 1300, "Jane Austen");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.removeId(2);

        Product[] expected = {book1, book3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removingExistingThirdBook() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "Pride and Prejudice", 1300, "Jane Austen");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.removeId(3);

        Product[] expected = {book1, book2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removingNotExistingID() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "Pride and Prejudice", 1300, "Jane Austen");
        Book book2 = new Book(2, "The Great Gatsby", 1800, "F. Scott Fitzgerald");
        Book book3 = new Book(3, "Flowers for Algernon", 900, "Daniel Keyes");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeId(4)
        );
    }
}
