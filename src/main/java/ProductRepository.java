public class ProductRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void save(PurchaseItem item) {
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeItemById(int id) {
        PurchaseItem[] tmp = new PurchaseItem[items.length - 1];
        int copyToIndex = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public PurchaseItem findById(int id) {
        for (PurchaseItem item : getItems()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        PurchaseItem result = findById(id);
        if (result == null) {
            NotFoundException s = new NotFoundException("Element with id: " + id + " not found");
            throw s;
        } else {
            removeItemById(id);
        }
    }


    public PurchaseItem[] getItems() {
        return items;
    }
}
