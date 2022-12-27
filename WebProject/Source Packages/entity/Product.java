/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author trinh
 */
public class Product {
    private int id;
    private String name;
    private String image;
    private double price;
    private String description;
	private int catalog_id;
	private double discount;
	private String image_link;
	private int quantity;

    public Product() {
    }

    public Product(int id, int catalog_id ,String name, double price, String description, double discount,
    		String image_link ,int quantity ) {
        this.id = id;
        this.catalog_id = catalog_id;
        this.name = name;
        this.price = price;
        this.description= description;
        this.discount =discount; 
        this.image_link = image_link;
        this.quantity = quantity;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", description="
				+ description + ", catalog_id=" + catalog_id + ", discount=" + discount + ", image_link=" + image_link
				+ ", quantity=" + quantity + "]";
	}


    
}
