package assignment.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq") 
	@SequenceGenerator(name="orderseq", sequenceName = "order_seq", allocationSize = 1)
	private long id;
	private String name;
	private String desc_item;
	private int curr_quantity;
	private int reorder_quantity;
	private int max_quantity;
	
	public Item() {}

	public Item(String name, String desc_item, int curr_quantity, int reorder_quantity, int max_quantity) {
		this.name = name;
		this.desc_item = desc_item;
		this.curr_quantity = curr_quantity;
		this.reorder_quantity = reorder_quantity;
		this.max_quantity = max_quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc_item() {
		return desc_item;
	}

	public void setDesc_item(String desc_item) {
		this.desc_item = desc_item;
	}

	public int getCurr_quantity() {
		return curr_quantity;
	}

	public void setCurr_quantity(int curr_quantity) {
		this.curr_quantity = curr_quantity;
	}

	public int getReorder_quantity() {
		return reorder_quantity;
	}

	public void setReorder_quantity(int reorder_quantity) {
		this.reorder_quantity = reorder_quantity;
	}

	public int getMax_quantity() {
		return max_quantity;
	}

	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}
	
}
