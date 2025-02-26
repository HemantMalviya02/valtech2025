package assignment.spring;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class LineItems {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineseq")
	@SequenceGenerator(name = "lineseq", sequenceName = "line_seq", allocationSize = 1)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item item;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="order_id", referencedColumnName = "id")
	private Order order;
	
}
