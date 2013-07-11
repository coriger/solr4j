package com.nojava.model.solr;

public enum SelectType {
	DISMAX("dismax"),SELECT("select");
	private final String type;
	public String getType(){
		return type;
	}
	SelectType(String type) {
		this.type=type;
	}
}
