package com.httpclient.httpclientDemo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.htmlparser.beans.LinkBean;
/**
 * html 页面解析demo
 * 获取一个页面的所有URL
 * @author Kyrin
 */
public class HtmlParserDemo {
	
	//获取一个页面中的所有url
	public static  List<String> getAllURL(String url){
		LinkBean linkBean = new LinkBean();
		linkBean.setURL(url);
		List<String> list=new ArrayList<String>();
		for(URL u: linkBean.getLinks()){
		list.add(u.toString());
		}
		return list;
	}
	
	public static void main(String a[]){
		List<String> list=getAllURL("http://www.lagou.com");
		for(String url:list){
			System.out.println(url);
		}
	}
}

