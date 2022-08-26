import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTestTwo {

        PurchaseItem item1 = new PurchaseItem(1, 1, "хлеб", 40, 3);
        PurchaseItem item2 = new PurchaseItem(2, 22, "булка", 30, 1);
        PurchaseItem item3 = new PurchaseItem(2, 30, "картофель", 20, 7);


        @Test
        public void shouldAddItem() {
            ProductRepository repo = new ProductRepository();

            repo.add(item1);
            repo.add(item2);

            PurchaseItem[] expected = { item1, item2 };
            PurchaseItem[] actual = repo.getItems();

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
    public void shouldShowException() {
            ProductRepository repo = new ProductRepository();

            repo.add(item1);
            repo.add(item2);


            Assertions.assertThrows(AlreadyExistsException.class, () -> {
                repo.add(item3);
            });
        }
}

