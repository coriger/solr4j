package com.nojava.utils.solr;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

/**
 * solr服务器工厂类
 * @author cailei
 *
 */
public class SolrServerFactory {

	private SolrServerFactory() {

	}

	private static final Logger log=Logger.getLogger(SolrServerFactory.class);
	private static  String solrServerUrl =null;
	
	static{
		try {
			Properties properties=new Properties();
			properties.load(ClassLoader.getSystemResourceAsStream("solrconfig.properties"));
			solrServerUrl=properties.getProperty("solr.url");
		} catch (IOException e) {
			log.error("载入solr.properties 配置文件出错", e);
		}
	}

	public static HttpSolrServer getSolrServer() throws MalformedURLException {
		if (solrServerUrl == null) {
			throw new IllegalArgumentException();
		}
		HttpSolrServer server = new HttpSolrServer(solrServerUrl);
		return server;
	}
	
	public static HttpSolrServer getSolrServer(String coreName)
			throws MalformedURLException {
		if (solrServerUrl == null) {
			throw new IllegalArgumentException();
		}
		String currentSolrServerUrl = solrServerUrl +coreName + "/";
		HttpSolrServer server = new HttpSolrServer(currentSolrServerUrl);
		return server;
	}
	public static void main(String[] args) {
		
	}
	
}
