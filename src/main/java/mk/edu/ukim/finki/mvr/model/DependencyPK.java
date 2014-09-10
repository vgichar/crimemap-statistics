package mk.edu.ukim.finki.mvr.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
public class DependencyPK implements Serializable{

	private DropDownList list;

	public DependencyPK()
	{
		
	}
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="key",insertable=false,updatable=false) , @JoinColumn(name="value",insertable=false,updatable=false)})
	public DropDownList getList() {
		return list;
	}

	public void setList(DropDownList list) {
		this.list = list;
	}
	
}
