package assignment.spring;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO {
	void save(Item i);
	void update(Item i);
	void delete(long id);
	Item get(long id);
	List<Item> getAll();
}
