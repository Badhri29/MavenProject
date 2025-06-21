package org.pom;

import java.util.List;

import org.base.testingmethods.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registration extends BaseClass {

	public registration() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastName;

	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	private WebElement address;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement phone;

	@FindBy(xpath = "//input[@value='Male']")
	private WebElement male;

	@FindBy(xpath = "//input[@value='FeMale']")
	private WebElement female;

	@FindBy(xpath = "//input[@value='Cricket']")
	private WebElement cricket;

	@FindBy(xpath = "//input[@value='Movies']")
	private WebElement movies;

	@FindBy(xpath = "//input[@value='Hockey']")
	private WebElement hockey;

	@FindBy(xpath = "//div[@id='msdd']")
	private WebElement dropdownLanguage;

	@FindBy(xpath = "(//a[@class='ui-corner-all'])")
	private List<WebElement> languages;

	@FindBy(xpath = "//select[@ng-model='Skill']")
	private WebElement skills;

	@FindBy(xpath = "//span[@role='presentation']")
	private WebElement dropdownCountry;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement countrySearch;

	@FindBy(xpath = "//span[@class='select2-results']//li")
	private List<WebElement> countryList;

	@FindBy(xpath = "//select[@placeholder='Year']")
	private WebElement dobYear;

	@FindBy(xpath = "//select[@placeholder='Month']")
	private WebElement dobMonth;

	@FindBy(xpath = "//select[@placeholder='Day']")
	private WebElement dobDay;

	@FindBy(xpath = "//input[@ng-model='Password']")
	private WebElement password;

	@FindBy(xpath = "//input[@ng-model='CPassword']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement sumbit;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement refresh;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getSkills() {
		return skills;
	}

	public WebElement getDobYear() {
		return dobYear;
	}

	public WebElement getDobMonth() {
		return dobMonth;
	}

	public WebElement getDobDay() {
		return dobDay;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getSumbit() {
		return sumbit;
	}

	public WebElement getRefresh() {
		return refresh;
	}

	public List<WebElement> getLanguages(String... name) {
		for (String string : name) {
			for (WebElement webElement : languages) {
				if (webElement.getText().equalsIgnoreCase(string)) {
					webElement.click();
					break;
				}
			}
		}
		return languages;
	}

	public WebElement dropdownLanguage() {
		return dropdownLanguage;
	}

	public WebElement getDropDownCountry() {
		return dropdownCountry;
	}

	public WebElement getCountrySearchBasedSelect(String countryName) {
		getDropDownCountry().click();
		sendKeysWithEnter(countrySearch, countryName);
		return countrySearch;
	}

	public List<WebElement> getCountryListIndexBasedSelect(int index) {
		dropdownCountry.click();
		countryList.get(index).click();
		return countryList;
	}

	public void getGender(char gender) {
		if (Character.toUpperCase(gender) == 'M')
			male.click();
		else
			female.click();
	}

	public WebElement getCricket() {
		return cricket;
	}

	public WebElement getMovies() {
		return movies;
	}

	public WebElement getHockey() {
		return hockey;
	}
}
