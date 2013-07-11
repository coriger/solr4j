package com.nojava.model.solr;

public class SpellCheckReqBean {
	private String coreName;
	private String q;
	//默认给5条spell建议
	private int  count=5;
	public String getCoreName() {
		return coreName;
	}
	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
