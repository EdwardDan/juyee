package com.justonetech.sendSMS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.justonetech.kxt.SendKxt;


public class SendSMSServlet extends HttpServlet {

	private static final long serialVersionUID = 244554953229893949L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("content");
		String mobiles = request.getParameter("mobiles");
		SendKxt.SendKxtSMS(content, mobiles);
//			PrintWriter out = response.getWriter();
//			JSONObject data = new JSONObject();
//			try {
//				data.put("status", "2221");
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//			out.println(data.toString());
//		super.doPost(request, response);
	}
}
