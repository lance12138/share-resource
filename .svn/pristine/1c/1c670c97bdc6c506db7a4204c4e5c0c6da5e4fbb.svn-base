package com.jxust.util;



import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.util.VerifyCode;

@SuppressWarnings("serial")
public class VerifyCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();//取图片
		VerifyCode.output(image, response.getOutputStream());
		request.getSession().setAttribute("vCode", vc.getText());
	}
}
