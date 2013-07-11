package com.nojava.model.solr;


public class TermsSuggest {
	private Integer num;
	private String name;

	public TermsSuggest() { }

	public TermsSuggest(Integer num, String name) {
		this.num = num;
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
