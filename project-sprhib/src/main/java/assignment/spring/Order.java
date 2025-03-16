package assignment.spring;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name="orderseq", sequenceName = "order_seq", allocationSize = 1)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	@OneToMany(targetEntity = LineItems.class,  mappedBy = "order", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<LineItems> lineitems;

	public enum Status {PLACED,FAIL;}
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Order () {}	

	public Order(Status status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<LineItems> getLineitems() {
		return lineitems;
	}

	public void setLineitems(List<LineItems> lineitems) {
		this.lineitems = lineitems;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", lineitems=" + lineitems + ", status=" + status + "]";
	}

	

	
}
