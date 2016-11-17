package com.justonetech.system.filter;

import com.justonetech.system.manager.SysLogCustomManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.AbstractProcessingFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: tcg
 * Date: 2011-12-26
 * Time: 15:02:28
 * To change this template use File | Settings | File Templates.
 */
public class CustomAuthenticationProcessingFilter implements Filter {
    @Autowired
    private SysLogCustomManager sysLogCustomManager;

    public static String VALIDATION_CODE = "VALIDATION_CODE";
    public static String J_VALIDATION_CODE = "j_validation_code";
    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        sysLogCustomManager.logAll((HttpServletRequest) request);  //保存系统日志

        if ((request != null) && request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            String code = StringUtils.defaultIfEmpty(req
                    .getParameter("j_validation_code"), "");

            if (session.getAttribute(VALIDATION_CODE) != null) {
                String sessionCode = StringUtils.defaultIfEmpty(
                        (String) session
                                .getAttribute(VALIDATION_CODE), "");

                if (!code.equals("") && !sessionCode.equals("")
                        && !code.equalsIgnoreCase(sessionCode)) {
                    session
                            .setAttribute(
                                    AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,
                                    new BadCredentialsException("验证码错误!"));
                    RequestDispatcher rd = request
                            .getRequestDispatcher("/login.jsp?login_error=1");
                    req.setAttribute("SPRING_SECURITY_LAST_USERNAME", req
                            .getParameter("j_username"));
                    rd.forward(request, response);
                }

                // session.removeAttribute(Constants.VALIDATION_CODE);
            }
            //已使用spring security自带方式判断session是否过期

            //非法字符过滤
            HttpServletResponse res = (HttpServletResponse) response;
            String queryString = req.getQueryString();
            if(StringUtils.isNotBlank(queryString)){
                if(queryString.indexOf("<script>")>-1 ||queryString.indexOf("%3Cscript%3E")>-1){
//                throw new IOException("操作失败，请不要在链接中输入非法参数！");
                    res.sendError(404, "File not found!");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }


    public void init(FilterConfig arg0) throws ServletException {

    }
}
