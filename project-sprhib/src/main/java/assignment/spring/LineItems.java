package assignment.spring;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity
public class LineItems {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineseq")
	@SequenceGenerator(name = "lineseq", sequenceName = "line_seq", allocationSize = 1)
	private long id;
	
	@ManyToOne(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item item;
	
	private int quantity;
	
	@ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="order_id", referencedColumnName = "id")
	private Order order;
	
	public LineItems () {}

	public LineItems(int quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
