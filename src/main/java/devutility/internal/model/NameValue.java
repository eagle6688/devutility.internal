package devutility.internal.model;

/**
 * 
 * NameValue
 * 
 * @author: Aldwin Su
 * @version: 2020-03-08 23:58:13
 */
public class NameValue {
	private String name;
	private String value;

	public NameValue() {

	}

	public NameValue(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}