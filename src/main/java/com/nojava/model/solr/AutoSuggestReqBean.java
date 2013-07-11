package com.nojava.model.solr;

public class AutoSuggestReqBean {
	private String coreName;
	private String prefix;
	private String regex;
	private int maxcount=-1;
	private int mincount=0;
	private int limit=10;
	private String field="suggest";
	private String sort = "count";
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public int getMaxcount() {
		return maxcount;
	}

	public void setMaxcount(int maxcount) {
		this.maxcount = maxcount;
	}

	public int getMincount() {
		return mincount;
	}

	public void setMincount(int mincount) {
		this.mincount = mincount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getCoreName() {
		return coreName;
	}

	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}
	
	public void buildSimpleReqBean(String coreName,String prefix){
		AutoSuggestReqBean autoSuggestReqBean=new AutoSuggestReqBean();
		autoSuggestReqBean.setCoreName(coreName);
		autoSuggestReqBean.setPrefix(prefix);
	}

}
