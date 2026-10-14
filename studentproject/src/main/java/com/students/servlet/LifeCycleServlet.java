package com.students.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// genericServlet is used for MIME (Multi-purpose Internet Mail Extensions) type of data. It is used to handle any type of data like text, image, audio, video, etc. 
// It is a protocol-independent servlet. It is used to handle any type of request and response. 
// It is used to handle any type of data like text, image, audio, video, etc. 
// It is a protocol-independent servlet. It is used to handle any type of request and response.

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {

     private int requestCount = 0;
    private String initTime  = "";

// ─────────────────────────────────────────────
    // LIFECYCLE STEP 1: init()
    // Called ONCE when servlet is first loaded
    // ─────────────────────────────────────────────
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initTime = new java.util.Date().toString();
        System.out.println("✅ init() called — Servlet is BORN at: " + initTime);
    }

    // ─────────────────────────────────────────────
    // LIFECYCLE STEP 2: service()
    // Called for EVERY request — routes to doGet/doPost
    // ─────────────────────────────────────────────
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        requestCount++;
        System.out.println("🔄 service() called — Request #" + requestCount);
        super.service(req, res); // calls doGet or doPost
    }

     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("📥 doGet() called");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(

            "<html><head><title>LifeCycle Servlet</title></head><body>" +
            "<h1>Servlet Lifecycle Demo</h1>" +
            "<p>Servlet initialized at: " + initTime + "</p>" +
            "<p>Total requests handled: " + requestCount + "</p>" +
            "</body></html>"
        );
    }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       


    }

     // ─────────────────────────────────────────────
    // LIFECYCLE STEP 4: destroy()
    // Called ONCE when server shuts down
    // ─────────────────────────────────────────────
    @Override
    public void destroy() {
        System.out.println("🔴 destroy() called — Servlet is DEAD");
        System.out.println("   Total requests handled: " + requestCount);
    }




}
