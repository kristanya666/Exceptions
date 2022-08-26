import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    PurchaseItem item1 = new PurchaseItem(1, 1, "хлеб", 40, 3);
    PurchaseItem item2 = new PurchaseItem(2, 22, "булка", 30, 1);
    PurchaseItem item3 = new PurchaseItem(3, 30, "картофель", 20, 7);


    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        repo.removeById(2);

        PurchaseItem[] expected = {item1, item3};
        PurchaseItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowException() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });

    }
}
