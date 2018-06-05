package devutility.internal.security.ldap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LdapAccount extends HashMap<String, List<String>> {
	private static final long serialVersionUID = 1150936436248723995L;

	public List<String> get(String key) {
		List<String> values = super.get(key);

		if (values == null) {
			return new LinkedList<>();
		}

		return values;
	}
}