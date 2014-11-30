package com.httpclient.httpclientDemo;
import java.util.ArrayList;
import java.util.List;
/**
 * 获取一个网站的所有url
 * @author Kylin
 */
public class GetAllForSiteDemo {
	static List<String>  firstList=new ArrayList<String>();//待遍历url
	static List<String> secondList=new ArrayList<String>();//已遍历url
	static List<String> currentPage=new ArrayList<String>();//当前页面的所有url
	static long num=0;
	public static void getAllURLForSite(String url){
		System.out.println("开始遍历："+url);
		currentPage=HtmlParserDemo.getAllURL(url);
		System.out.println("当前页总共："+currentPage.size()+"个链接");

		//开始遍历当前页列表
		for(String uri:currentPage){
			if(!firstList.contains(uri.trim()) && !secondList.contains(uri) && uri.contains("www.lagou.com/gongsi")){//如果待遍历和已遍历列表中不存在
				firstList.add(uri);//添加到待遍历列表
				System.out.println(uri+"被添加到待遍历列表中");
			}
		}
		
		//当待遍历中存在，删除
		if(firstList.contains(url)){
			System.out.println(url+"被待遍历中删除！"+firstList.size());
			firstList.remove(url);
		}
		
		//遍历完当前页，将当前页列表清空
		currentPage=null;
		
		//添加到已遍历列表
		secondList.add(url);
	}
	public static void main(String a[]){
		firstList.add("http://www.lagou.com/");//初始化待遍历列表
		while(firstList.size()>0){
				getAllURLForSite(firstList.get(firstList.size()-1));				
				System.out.println("总共："+secondList.size());
		}
		
	}
}
