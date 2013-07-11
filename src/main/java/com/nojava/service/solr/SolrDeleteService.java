package com.nojava.service.solr;


import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

import com.nojava.utils.solr.SolrServerFactory;
public class SolrDeleteService {

	public void deleteId(String id, String coreName)
			throws SolrServerException, IOException {
		HttpSolrServer httpSolrServer = SolrServerFactory
				.getSolrServer(coreName);
		httpSolrServer.deleteById(id);
		httpSolrServer.commit();
	}

	public void deleteIds(List<String> ids, String coreName)
			throws SolrServerException, IOException {
		HttpSolrServer httpSolrServer = SolrServerFactory
				.getSolrServer(coreName);
		httpSolrServer.deleteById(ids);
		httpSolrServer.commit();
	}

}
