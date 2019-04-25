package devutility.internal.ldap;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * LdapEntry
 * 
 * @author: Aldwin Su
 * @version: 2019-04-19 15:31:02
 */
public class LdapEntry extends HashMap<String, List<String>> {
	private static final long serialVersionUID = 1150936436248723995L;

	private String name;

	public LdapEntry() {

	}

	public LdapEntry(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public <T> T getValue(String key) {
		Object value = this.get(key);

		if (value == null) {
			return null;
		}

		return (T) value;
	}
}