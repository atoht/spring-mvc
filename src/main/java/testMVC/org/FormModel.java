package testMVC.org;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class FormModel {
	private String input1;
	private String pass1;
	private String area1;
	private boolean check1;
	private boolean check;
	private String[] checks1;
	private String radio;
	private String select;
	private String radi;
	@NotEmpty()
	private String item;
	@Min(value=0)
	@Digits(fraction=3, integer = 5)
	private Double price;
	@Future
//	@DateTimeFormat(pattern="yy/mm/dd")
	private Date buyDate;
	private String memo;
	@Email
	private String mail;
	
	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getArea1() {
		return area1;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public boolean isCheck1() {
		return check1;
	}

	public void setCheck1(boolean check1) {
		this.check1 = check1;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String[] getChecks1() {
		return checks1;
	}

	public void setChecks1(String[] checks) {
		this.checks1 = checks;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getRadi() {
		return radi;
	}

	public void setRadi(String radi) {
		this.radi = radi;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
