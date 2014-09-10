package mk.edu.ukim.finki.mvr.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DropDownListPK implements Serializable{

	private String key;
	
	private String value;

	public DropDownListPK()
	{
		
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
