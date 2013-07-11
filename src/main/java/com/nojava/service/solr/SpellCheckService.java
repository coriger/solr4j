package com.nojava.service.solr;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.solr.client.solrj.SolrQuery;

import com.nojava.model.solr.SpellCheckReqBean;
import com.nojava.model.solr.SpellCheckResultBean;
import com.nojava.utils.solr.HttpUtils;
import com.nojava.utils.solr.SolrPath;
public class SpellCheckService {

	public SpellCheckResultBean getsSpellCheckResultBean(
			SpellCheckReqBean reqBean) {
		SpellCheckResultBean resultBean = new SpellCheckResultBean();
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q", reqBean.getQ());
		solrQuery.set("spellcheck.build", true);
		solrQuery.set("spellcheck.count", reqBean.getCount());
		String url = SolrPath.SOLR_URL + reqBean.getCoreName() + "/spell?"
				+ solrQuery.toString();
		JSONObject jsonResponse = HttpUtils.getResponseBodyAsJson(url)
				.getJSONObject("spellcheck");
		JSONArray suggestions=jsonResponse.getJSONArray("suggestions");
		if(suggestions.size()>0){
			JSONArray terms =suggestions
					.getJSONObject(1).getJSONArray("suggestion");
			for (int i = 0; i < terms.size(); i++) {
				resultBean.addSpellCheckName(terms.getString(i));
			}
		}
		return resultBean;
	}

}
