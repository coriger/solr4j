package com.nojava.utils.solr;

import java.io.IOException;
import java.io.InputStream;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class HttpUtils {
	
	private static Logger log=Logger.getLogger(HttpUtils.class);

	/**
	 * GET 方法请求 url
	 *
	 * @param url http url
	 * @return
	 */
	public static  int getResponseCode(String url) {
		HttpClient client = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true));
		GetMethod getMethod = new GetMethod(url);
		getMethod.setRequestHeader("Connection", "close");
		int responseCode = -1;
		try {
			responseCode = client.executeMethod(getMethod);
		} catch (HttpException e) {
			log.error("http exception", e);
		} catch (IOException e) {
			log.error("io exception", e);
		}finally{
			getMethod.releaseConnection();
			((SimpleHttpConnectionManager)client.getHttpConnectionManager()).shutdown();
		}
		return responseCode;
	}

	/**
	 * GET 方法请求url，并将返回数据封装成JSONObject
	 *
	 * @param url http url
	 * @return
	 */
	public static  JSONObject getResponseBodyAsJson(String url) {
		HttpClient client = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true));
		GetMethod getMethod = new GetMethod(url);
		getMethod.setRequestHeader("Connection", "close");
		JSONObject json = null;
		try {
			client.executeMethod(getMethod);
			InputStream in = getMethod.getResponseBodyAsStream();
			String responseBody = IOUtils.toString(in, "UTF-8");
			in.close();
			json = JSONObject.fromObject(responseBody);
		} catch (IOException e) {
			log.error("io exception", e);
		} catch (JSONException e) {
			log.error("json parse exception", e);
		}finally{
			getMethod.releaseConnection();
			((SimpleHttpConnectionManager)client.getHttpConnectionManager()).shutdown();
		}
		return json;
	}
}
