package assignment.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private ItemDAO itemDAO;
	
	public boolean existingItem(long itemId, int quantityAsked) {
//		System.out.println("-------------------------"+itemId);
		Item existingItem = itemDAO.get(itemId);
//		System.out.println("==========================");
		System.out.println(existingItem);
		
		if(existingItem != null && existingItem.getCurrQuantity() >= quantityAsked) {
			existingItem.setCurrQuantity(existingItem.getCurrQuantity() - quantityAsked);
			
			// now we need to update reorder quantity also, adding by how much quantity asked
			existingItem.setReorderQuantity(existingItem.getReorderQuantity() + quantityAsked);
			itemDAO.update(existingItem);
			return true;
		}
		else 
			return false;
	}
	
	public void updateCurrQuantity(long itemId) {
		Item it = itemDAO.get(itemId);
		
		if(it.getReorderQuantity() == it.getMaxQuantity()) {
			it.setCurrQuantity(it.getMaxQuantity());
			it.setReorderQuantity(0);
			itemDAO.update(it);
		}
		
		
		
//		if(it.getCurrQuantity() == it.getReorderQuantity()) {
//			it.setCurrQuantity(it.getMaxQuantity());
//			item.update(it);
//		}
		
		

		//logic
		// if currQuan == reorderQuan { increase currQuan till maxQuan }
		//update currQuan

		
	}

	@Override
	public void save(Item i) {
		itemDAO.save(i);
		
	}

	@Override
	public void update(Item i) {
		itemDAO.update(i);
		
	}

	@Override
	public void delete(long id) {
		itemDAO.delete(id);
		
	}

	@Override
	public Item get(long id) {
		return itemDAO.get(id);
	}

	@Override
	public List<Item> getAll() {
		return itemDAO.getAll();
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	
}
