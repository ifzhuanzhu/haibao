package com.ssh.comm.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssh.comm.GlobalConstants;

@WebFilter(filterName = "loginFilter", urlPatterns = ("/*"), initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8"),
		@WebInitParam(name = "loginPage", value = "/login.do"),
		@WebInitParam(name = "opLogin", value = "/login!login.do"),
		@WebInitParam(name = "proLogin", value = "/") })
public class LoginFilter implements Filter {

	private FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void destroy() {
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String requestPath = httpRequest.getServletPath();
		String loginPage = config.getInitParameter("loginPage");
		String opLogin = config.getInitParameter("opLogin");
		String proLogin = config.getInitParameter("proLogin");
		if (!requestPath.equals(proLogin) && !requestPath.equals(loginPage) && !requestPath.equals(opLogin)
				&& httpRequest.getSession(true).getAttribute(GlobalConstants.SESSION_ADMIN_KEY) == null) 
		{
			String redirectUrl = String.format("%s%s?redirectUrl=%s", httpRequest.getContextPath(), loginPage, getRedirectUrl(httpRequest));
			httpResponse.sendRedirect(redirectUrl);
		} 
		else 
		{
			filterChain.doFilter(request, response);
		}
	}
	
    private String getRedirectUrl(HttpServletRequest request) throws UnsupportedEncodingException{
        String url = request.getServletPath();
        if (request.getQueryString() != null) { 
          url += '?'; 
          url += request.getQueryString(); 
         }
        return URLEncoder.encode(url, "UTF-8");
    }

}
