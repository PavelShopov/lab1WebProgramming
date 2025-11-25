package com.example.labs1.web;

import com.example.labs1.model.Chef;
import com.example.labs1.model.Dish;
import com.example.labs1.service.ChefService;
import com.example.labs1.service.DishService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="ChefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {
    private final DishService dishService;
    private final ChefService chefService;
    private final SpringTemplateEngine springTemplateEngine;
    public ChefDetailsServlet( SpringTemplateEngine springTemplateEngine,ChefService chefService,DishService dishService) {
        this.dishService = dishService;
        this.chefService = chefService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("chef", (Chef) req.getSession().getAttribute("chef"));
        springTemplateEngine.process("dishesList.html", context, resp.getWriter());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
