package com.example.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter  extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println( "using post filter");
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
