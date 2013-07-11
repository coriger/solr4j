package com.nojava.utils.solr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SolrPath {

	public static final String SOLR_CONFIG_PROPERTIES = "/solrconfig.properties";

	private static Properties properties = new Properties();

	public static String SOLR_URL;

	static {
		InputStream inStream = SolrPath.class.getResourceAsStream(SOLR_CONFIG_PROPERTIES);
		try {
			properties.load(inStream);
		} catch (IOException e) {
			System.err.println("can not load properties: " + SOLR_CONFIG_PROPERTIES);
			e.printStackTrace(System.err);
		}
		SOLR_URL = properties.getProperty("solr.url");
	}

}
