package com.azad.fizzbuzz.controller;

import com.azad.fizzbuzz.service.FizzBuzzService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getFirstHundred.do")
public class FizzBuzzServlet extends HttpServlet {

    FizzBuzzService fizzBuzzService = new FizzBuzzService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String limit = request.getParameter("limit");
        String result = "0";

        if (limit.isEmpty()) {
            request.setAttribute("limit", "0");

        } else {
            request.setAttribute("limit", limit);
            Integer value = Integer.valueOf(limit);
            if (value != 0) {
                result = fizzBuzzService.getResult(value);
            }
        }

        request.setAttribute("result", result);
		request.getRequestDispatcher("/WEB-INF/index.jsp")
			.forward(request, response);
    }
}
