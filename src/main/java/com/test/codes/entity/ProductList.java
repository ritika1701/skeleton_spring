package com.test.codes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Document(collection = "productList")
public class ProductList {

	@Id
	private String id;

	private String uniq_id;
	private String product_name;
	private BigDecimal retail_price;
	private BigDecimal discounted_price;
	private List<String> image;

	private String description;
	private String product_rating;
	private String overall_rating;
	private String brand;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductList that = (ProductList) o;
		return Objects.equals(uniq_id, that.uniq_id) && Objects.equals(product_name, that.product_name) && Objects.equals(retail_price, that.retail_price) && Objects.equals(discounted_price, that.discounted_price) && Objects.equals(image, that.image) && Objects.equals(description, that.description) && Objects.equals(product_rating, that.product_rating) && Objects.equals(overall_rating, that.overall_rating) && Objects.equals(brand, that.brand);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uniq_id, product_name, retail_price, discounted_price, image, description, product_rating, overall_rating, brand);
	}

	@Override
	public String toString() {
		return "ProductList{" +
				"uniq_id='" + uniq_id + '\'' +
				", product_name='" + product_name + '\'' +
				", retail_price=" + retail_price +
				", discounted_price=" + discounted_price +
				", image=" + image +
				", description='" + description + '\'' +
				", product_rating='" + product_rating + '\'' +
				", overall_rating='" + overall_rating + '\'' +
				", brand='" + brand + '\'' +
				'}';
	}

	public String getUniq_id() {
		return uniq_id;
	}

	public void setUniq_id(String uniq_id) {
		this.uniq_id = uniq_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public BigDecimal getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(BigDecimal retail_price) {
		this.retail_price = retail_price;
	}

	public BigDecimal getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(BigDecimal discounted_price) {
		this.discounted_price = discounted_price;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduct_rating() {
		return product_rating;
	}

	public void setProduct_rating(String product_rating) {
		this.product_rating = product_rating;
	}

	public String getOverall_rating() {
		return overall_rating;
	}

	public void setOverall_rating(String overall_rating) {
		this.overall_rating = overall_rating;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}