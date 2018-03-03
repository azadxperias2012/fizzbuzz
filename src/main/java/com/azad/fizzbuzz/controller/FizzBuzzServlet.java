package com.azad.fizzbuzz.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet(urlPatterns = "/getFirstHundred.do")
public class FizzBuzzServlet extends HttpServlet {

    static final String LIMIT = "limit";
    static final String RESULT = "result";
    static final String REDIRECTION_PAGE = "/WEB-INF/index.jsp";
    static final String FIZZBUZZ_ENDPOINT = "https://fizzbuzz-web-api.herokuapp.com/fizzbuzz/api/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String limit = request.getParameter(LIMIT);
        String result = "0";

        if (limit.isEmpty()) {
            request.setAttribute(LIMIT, "0");

        } else {
            request.setAttribute(LIMIT, limit);
            Integer value = Integer.valueOf(limit);
            if (value != 0) {
                result = getResult(value);
            }
        }

        request.setAttribute(RESULT, result);
		request.getRequestDispatcher(REDIRECTION_PAGE)
			.forward(request, response);
    }

    private String getResult(int value) {
        String result = "";
        try {
            URL url = new URL(FIZZBUZZ_ENDPOINT + value);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();
            result = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
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
    */
}
