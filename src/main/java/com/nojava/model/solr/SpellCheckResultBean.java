package com.nojava.model.solr;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckResultBean {
	
	private List<String> list=new ArrayList<String>(5);

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	public void addSpellCheckName(String name){
		list.add(name);
	}
	
}
