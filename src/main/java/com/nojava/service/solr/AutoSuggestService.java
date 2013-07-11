package com.nojava.service.solr;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.solr.client.solrj.SolrQuery;

import com.nojava.model.solr.AutoSuggestReqBean;
import com.nojava.model.solr.AutoSuggestResultBean;
import com.nojava.model.solr.TermsSuggest;
import com.nojava.utils.solr.HttpUtils;
import com.nojava.utils.solr.SolrPath;
public class AutoSuggestService {

	public AutoSuggestResultBean getSuggestResultBean(AutoSuggestReqBean reqBean) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setTermsMaxCount(reqBean.getMaxcount());
		solrQuery.setTermsMinCount(reqBean.getMincount());
		solrQuery.setTermsLimit(reqBean.getLimit());
		solrQuery.setTermsPrefix(reqBean.getPrefix());
		solrQuery.setTermsSortString(reqBean.getSort());
		solrQuery.set("terms.fl", reqBean.getField());
		solrQuery.set("wt", "json");
		String url = SolrPath.SOLR_URL + reqBean.getCoreName() + "/terms?"
				+ solrQuery.toString();
		JSONObject terms= (JSONObject) HttpUtils.getResponseBodyAsJson(url).get("terms");
		JSONArray suggest=(JSONArray) terms.get("suggest");
		AutoSuggestResultBean resultBean = new AutoSuggestResultBean();
		for (int i = 0; i < suggest.size()-1; i++) {
			String suggestName = (String) suggest.get(i);
			int position=suggestName.indexOf("$$");
			if(position!=-1){
				suggestName=suggestName.substring(position+2, suggestName.length());
			}
			Integer suggestNum = Integer.parseInt(suggest.get(++i).toString());
			resultBean.addTerms(new TermsSuggest(suggestNum, suggestName));
		}
		return resultBean;
	}
	

}
