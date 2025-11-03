package com.example.labs1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.labs1.service.ChefService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="ChefListServlet", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {
    ChefService  chefService;
    private final SpringTemplateEngine springTemplateEngine;
    public ChefListServlet(SpringTemplateEngine springTemplateEngine, ChefService chefService) {
        this.chefService = chefService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("chefs", this.chefService.listChefs());
        springTemplateEngine.process("listChefs.html", context, resp.getWriter());
    }


}
