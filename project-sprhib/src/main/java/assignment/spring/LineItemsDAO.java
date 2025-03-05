package assignment.spring;

import java.util.List;

public interface LineItemsDAO {
	void save(LineItems li);
	void update(LineItems li);
	void delete(long li);
	LineItems get(long id);
	List<LineItems> getAll();
}
