package lk.sky360solutions.authorization.role.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

	private String name;

	private String brand;

	private String madein;

	private float price;

}
