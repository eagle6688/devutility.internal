package devutility.internal.com;

/**
 * 
 * CommonResultCode
 * 
 * @author: Aldwin Su
 * @version: 2020-12-16 15:35:45
 */
public enum CommonResultCode {
	/**
	 * System error
	 */
	SYSTEMERROR(1001, "System error."),

	/**
	 * Request remote service failed.
	 */
	REQUESTREMOTESERVICEFAILED(1002, "Request remote service failed."),

	/**
	 * Parameter verification failed.
	 */
	PARAMETERVERIFICATIONFAILED(1011, "Parameter verification failed."),

	/**
	 * Parameter empty.
	 */
	PARAMETEREMPTY(1012, "Parameter empty."),

	/**
	 * Parameter invalid.
	 */
	PARAMETERINVALID(1013, "Parameter invalid."),

	/**
	 * Parameter length exceed.
	 */
	PARAMETERLENGTHEXCEED(1014, "Parameter length exceed."),

	/**
	 * Parameter duplicated.
	 */
	PARAMETERDUPLICATED(1015, "Parameter duplicated."),

	/**
	 * Parameter with invalid char.
	 */
	PARAMETERWITHINVALIDCHAR(1016, "Parameter with invalid char."),

	/**
	 * Parameter with invalid type.
	 */
	PARAMETERWITHINVALIDTYPE(1017, "Parameter with invalid type."),

	/**
	 * Parameter with invalid format.
	 */
	PARAMETERWITHINVALIDFORMAT(1018, "Parameter with invalid format."),

	/**
	 * Collection parameter item exceed.
	 */
	COLLECTIONPARAMETERITEMEXCEED(1021, "Collection parameter item exceed."),

	/**
	 * Invalid page index.
	 */
	PAGEINDEXINVALID(1031, "Invalid page index."),

	/**
	 * Invalid page size.
	 */
	PAGESIZEINVALID(1032, "Invalid page size."),

	/**
	 * Page size exceed.
	 */
	PAGESIZEEXCEED(1033, "Page size exceed."),

	/**
	 * Record existed.
	 */
	RECORDEXISTED(1041, "Record existed."),

	/**
	 * Record not found.
	 */
	RECORDNOTFOUND(1042, "Record not found."),

	/**
	 * Data save failed.
	 */
	DATASAVEFAILED(1051, "Data save failed."),

	/**
	 * Data add failed.
	 */
	DATAADDFAILED(1052, "Data add failed."),

	/**
	 * Data update failed.
	 */
	DATAUPDATEFAILED(1053, "Data update failed."),

	/**
	 * Data delete failed.
	 */
	DATADELETEFAILED(1054, "Data delete failed.");

	private int code;
	private String description;

	CommonResultCode(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public boolean isCode(String value) {
		return this.getCodeAsString().equals(value);
	}

	public int getCode() {
		return code;
	}

	public String getCodeAsString() {
		return String.valueOf(code);
	}

	public String getDescription() {
		return description;
	}
}