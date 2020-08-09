package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "salesOrder")
@Getter
@Setter
public class SalesOrder implements Serializable {

	private static final long serialVersionUID = -6571020025726257848L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Cart cart;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private ShippingAddress shippingAddress;

	@ManyToOne
	private BillingAddress billingAddress;

	
}
