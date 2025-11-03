package com.example.labs1.web;

import com.example.labs1.bootstrap.DataHolder;
import com.example.labs1.model.Chef;
import com.example.labs1.repository.impl.InMemoryChefRepository;
import com.example.labs1.repository.impl.InMemoryDishRepository;
import com.example.labs1.service.impl.ChefServiceImpl;
import jakarta.annotation.PostConstruct;
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
import java.util.List;

@WebServlet(name="ChefListServlet", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {
    private final ChefService chefService;
    private final SpringTemplateEngine springTemplateEngine;

    public ChefListServlet(SpringTemplateEngine springTemplateEngine) {
        this.chefService = new ChefServiceImpl(new InMemoryChefRepository(), new InMemoryDishRepository());
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
            public void init() throws ServletException {
        DataHolder dataHolder = new DataHolder();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        List<Chef> chefs = this.chefService.listChefs();
        context.setVariable("chefs", this.chefService.listChefs());
        springTemplateEngine.process("listChefs.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String chefID = req.getParameter("chefID");
        context.setVariable("chefID", chefID);
        resp.sendRedirect("/dish");
    }
}
