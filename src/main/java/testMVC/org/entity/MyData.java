package testMVC.org.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="mydata")
@NamedQueries (
		@NamedQuery (
				name="find",
				query="from MyData where id =:fid or name like :fname or mail like :fmail"
				)
		)
public class MyData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long id;
	
	@NotEmpty
	@Column(length=50, nullable=false)
	private String name;
	
	@Email
	@Column(length=200, nullable=true)
	private String mail;
	
	@Min(0)
	@Column(nullable=true)
	private int age;
	
	@Column(nullable=true)
	private String memo;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
