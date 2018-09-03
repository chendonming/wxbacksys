package com.lzs.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	public static String doGet(String url, Map<String, String> param)
	{

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		// 封装请求参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if (param != null) {
			for (String key : param.keySet()) {
				params.add(new BasicNameValuePair(key, param.get(key)));
			}
		}
		try {
			// 转换为键值对
			String urlParam = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			System.out.println("urlParam:" + urlParam);
			if (url.indexOf("?") > -1) {
				url += urlParam;
			} else {
				url += "?" + urlParam;
			}
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(url);
			// 执行请求
			response = httpClient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
			} else {
				System.out.println(url + ",网络错误：" + response.getStatusLine().getStatusCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("httpclient close fail");
			}
		}
		return resultString;
	}

	public static String doGetToken(String url, Map<String, String> param, String access_token)
	{

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		// 封装请求参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if (param != null) {
			for (String key : param.keySet()) {
				params.add(new BasicNameValuePair(key, param.get(key)));
			}
		}
		try {
			// 转换为键值对
			String urlParam = EntityUtils.toString(new UrlEncodedFormEntity(
					params, Consts.UTF_8));
			if (url.indexOf("?") > -1) {
				url += "&" + urlParam;
			} else {
				url += "?" + urlParam;
			}
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(url);
			httpGet.addHeader("access_token", access_token);
			// 执行请求
			response = httpClient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(),
						Consts.UTF_8);
			} else {
				System.out.println(url + ",网络错误："
						+ response.getStatusLine().getStatusCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("httpclient close fail");
			}
		}
		return resultString;
	}

	public static String doPost(String url, Map<String, String> param)
	{

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
			} else {
				System.out.println(url + ",网络错误：" + response.getStatusLine().getStatusCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("httpclient close fail");
			}
		}
		return resultString;
	}

	public static String doPostToken(String url, Map<String, String> param, String access_token)
	{

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
						paramList, Consts.UTF_8);
				httpPost.setEntity(entity);
			}
			httpPost.addHeader("access_token", access_token);
			// 执行http请求
			response = httpClient.execute(httpPost);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(),
						Consts.UTF_8);
			} else {
				System.out.println(url + ",网络错误："
						+ response.getStatusLine().getStatusCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("httpclient close fail");
			}
		}
		return resultString;
	}

	public static String doPostJson(String url, String json)
	{

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json,
					ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(),
						Consts.UTF_8);
			} else {
				System.out.println(url + ",网络错误："
						+ response.getStatusLine().getStatusCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("httpclient close fail");
			}
		}
		return resultString;
	}
}
