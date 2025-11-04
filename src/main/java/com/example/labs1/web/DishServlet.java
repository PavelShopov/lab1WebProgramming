package com.example.labs1.web;

import com.example.labs1.bootstrap.DataHolder;
import com.example.labs1.model.Chef;
import com.example.labs1.repository.impl.InMemoryChefRepository;
import com.example.labs1.repository.impl.InMemoryDishRepository;
import com.example.labs1.service.ChefService;
import com.example.labs1.service.DishService;
import com.example.labs1.service.impl.ChefServiceImpl;
import com.example.labs1.service.impl.DishServiceImpl;
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
import java.util.List;

@WebServlet(name="DishServlet",urlPatterns = "/dish")
public class DishServlet extends HttpServlet {

    private final DishService dishService;
    private final ChefService chefService;
    private final SpringTemplateEngine springTemplateEngine;
    public DishServlet( SpringTemplateEngine springTemplateEngine) {
        this.dishService = new DishServiceImpl(new InMemoryDishRepository());
        this.chefService = new ChefServiceImpl(new InMemoryChefRepository(), new InMemoryDishRepository());
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("chef", req.getParameter("chefID") == null ? null : chefService.findById(Long.parseLong(req.getParameter("chefID"))) );
        context.setVariable("dishes", this.dishService.listDishes());
        springTemplateEngine.process("dishesList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dishID = req.getParameter("dishID");
        Chef chef = (Chef) req.getAttribute("chef");
        resp.sendRedirect("/chefDetails?chefID=" + chef.getMyID()+"&dishID=" + dishID);
    }
}
