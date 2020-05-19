package com.example.demo.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter
{

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException 
	{
		RequestContext ctx=new RequestContext();
		HttpServletRequest request=ctx.getRequest();
		System.out.println("Request Method :" +request.getMethod()+"Request URl :"+
		request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		return null;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
