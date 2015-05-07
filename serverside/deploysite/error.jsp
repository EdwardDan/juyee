<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<%@page import="org.apache.commons.lang.exception.ExceptionUtils" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<style type="text/css">
    body {
        font-size: 12px;
    }
</style>
<%
    try {
        //返回页面
        String redirectPage = "login.jsp";
        String referer = request.getHeader("REFERER");
        if (referer != null) {
            if (referer.indexOf("/site/") >= 0) {
                redirectPage = "site/index.do";
            }
        }
        String nullPage = "您所访问的页面不存在，请和管理员联系! <a href='" + request.getContextPath() + "/" + redirectPage + "' target='_parent'>返回首页</a>";

        // 获取错误状态码
        String statusCode = StringUtils.defaultIfEmpty(String.valueOf(request.getAttribute("javax.servlet.error.status_code")), "");

        if (statusCode.equals("404")) {
            out.println(nullPage);
            return;
        } else if (statusCode.equals("500")) {
            String msg = "您所访问的页面出现了异常，请和管理员联系!";
            if (exception != null) {
                //记录日志
                Throwable ex = exception;
                Logger logger = LoggerFactory.getLogger("500.jsp");
                logger.error(ex.getMessage(), ex);

                if (ex.getMessage().indexOf("No matching handler method found for servlet request: path") >= 0) {
                    msg = nullPage;
                }
            }
            out.println(msg);

        } else {
            // The Servlet spec guarantees this attribute will be available
//		Throwable ex = (Throwable) request.getAttribute("javax.servlet.	.exception");
            Throwable ex = (Exception) request.getAttribute("javax.servlet.error.exception");
            System.out.println("...............ex.getMessage() = " + ex.getMessage());
            if (ex != null && ex instanceof ServletException) {
                // It's a ServletException: we should extract the root cause
                ServletException sex = (ServletException) ex;
                Throwable rootCause = sex.getRootCause();
                if (rootCause == null)
                    rootCause = sex;
                out.println("系统处理过程中出现了异常，异常消息如下: " + rootCause.getMessage());
                rootCause.printStackTrace(new java.io.PrintWriter(out));
//			rootCause.printStackTrace();
            } else {
                if (ex != null) {
                    ex.printStackTrace();
                    String message = ExceptionUtils.getRootCause(ex).getLocalizedMessage();
                    if(message.contains("ORA-02292")){
                        out.println(" 当前记录已被关联，无法删除!");
                    }else{
                        out.println("系统处理过程中出现了异常，异常消息如下: " + message);
                    }

                } else {
                    out.println("系统处理过程中出现了异常，请和管理员联系!");
                }
            }
            out.close();
        }
    } catch (Exception e) {
        out.println("系统处理过程中出现了异常，异常消息如下: " + e.getMessage());
        e.printStackTrace();
    }
%>
