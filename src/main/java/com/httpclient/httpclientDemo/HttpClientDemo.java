package com.httpclient.httpclientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

/**
 * Httpclient 请求测试
 *@author Kyrin
 */
public class HttpClientDemo {
	
	static  Logger logger=Logger.getLogger(HttpClientDemo.class);
	 final static String HTTP_GET="GET";
	 final static  String HTTP_POST="POST";
	 final static int HTTP_ERROR=500;
	 final static int  HTTP_SUCCESS=200;
	 static HttpMethodBase method=null;
	 static HttpClient http=null;

	 public static void main( String[] args ){
    	String url="http://www.lagou.com/";
    	
    	//获取请求状态码
		int status=getHttpStatus(url,HTTP_GET);
		
	    System.out.println( "请求状态码：status="+status );

	    //当请求成功时
	    if(status==HTTP_SUCCESS){
	    	InputStream is=getResponseStream(method);
	    	BufferedReader reade=new BufferedReader(new InputStreamReader(is));
	    	String result=null;
	    	try {
				while((result=reade.readLine())!=null){
					System.out.println(result);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("IO异常！");
			}
	    }
	    
	    
    }
    
    
    

	public static int getHttpStatus(String uri,String flag){
		http=new HttpClient();
		if(flag.equals(HTTP_GET)){
			 method=new GetMethod(uri);
		}else if(flag.equals(HTTP_POST)){
			 method=new PostMethod(uri);
		}
		
		try {
			return http.executeMethod(method);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			logger.error("请求失败！");
			return HTTP_ERROR;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("IO异常！");
			return HTTP_ERROR;
		}
	}
	
	
	public static InputStream getResponseStream(HttpMethodBase method){
		try {
			return method.getResponseBodyAsStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("获取response时，IO异常！");
			return null;
		}
	}
	
	
}
