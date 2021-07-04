package cl.zco.rbernedo.jpademo.model;

import java.util.Date;

public class Job {
	
	private Integer id;
	private String name;
	private String description;
	private Date publicationDate;
	private Double salary;
	private Integer featured;
	private String image = "no-image.png";
	private String status;
	private String details;
	private Category category;

	public Job() {
		super();
	}

	public Job(Integer id, String name, String description, Date publicationDate, Double salary, Integer featured) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.publicationDate = publicationDate;
		this.salary = salary;
		this.featured = featured;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getFeatured() {
		return featured;
	}

	public void setFeatured(Integer featured) {
		this.featured = featured;
	}
	

	public String getImage() {
		return image;
	}

	public Job setImage(String image) {
		this.image = image;

		return this;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Job{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", publicationDate=" + publicationDate +
				", salary=" + salary +
				", featured=" + featured +
				", image='" + image + '\'' +
				", status='" + status + '\'' +
				", details='" + details + '\'' +
				", category=" + category +
				'}';
	}
}
