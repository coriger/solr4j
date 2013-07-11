package com.nojava.model.solr;

import java.util.ArrayList;
import java.util.List;

public class AutoSuggestResultBean {
	private List<TermsSuggest> termsList=new ArrayList<TermsSuggest>(10);
	
	
	public List<TermsSuggest> getTermsList() {
		return termsList;
	}


	public void setTermsList(List<TermsSuggest> termsList) {
		this.termsList = termsList;
	}

	public void addTerms(TermsSuggest termsSuggest){
		termsList.add(termsSuggest);
	}
}
