package assignment.spring;

import java.util.List;

public interface InventoryService {
	boolean existingItem(long itemId, int quantityAsked);
	void updateCurrQuantity(long itemId);
	void save(Item i);
	void update(Item i);
	void delete(long id);
	Item get(long id);
	List<Item> getAll();
}
