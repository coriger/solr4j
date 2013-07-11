package com.nojava.model.solr;

import java.util.Date;

public class DateField {
	private String dataTypeFiled;
	private Date start;
	private Date end;

	public DateField(String dataTypeFiled, Date start, Date end) {
		this.dataTypeFiled = dataTypeFiled;
		this.start = start;
		this.end = end;
	}

	public String getDataTypeFiled() {
		return dataTypeFiled;
	}

	public void setDataTypeFiled(String dataTypeFiled) {
		this.dataTypeFiled = dataTypeFiled;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
