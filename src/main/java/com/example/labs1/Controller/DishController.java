package com.example.labs1.Controller;
import com.example.labs1.model.Dish;
import com.example.labs1.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dishes") // Основен мапинг за сите методи во контролерот
public class DishController {

    private final DishService dishService;

    // Инјектирање на DishService преку конструктор
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    /**
     * 4.1 Метод за листање на јадења
     * Прикажува го погледот listDishes.html со листа на сите јадења.
     * @param error Параметар за приказ на грешки (опционален).
     * @param model Модел за додавање атрибути за прикажување во погледот.
     * @return Име на погледот (listDishes).
     */
    @GetMapping // Одговара на mapping: /dishes
    public String getDishesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", Optional.of(true));
            model.addAttribute("error", error);
        }

        List<Dish> dishes = this.dishService.listDishes();
        model.addAttribute("dishes", dishes);
        model.addAttribute("bodyContent", "listDishes"); // Ако користите layout/фрагменти
        return "listDishes"; // Име на Thymeleaf/HTML погледот
    }

    /**
     * Помошен метод за приказ на формата за додавање/едитирање.
     * @param model Модел за додавање атрибути.
     * @return Име на погледот (add-edit-dish).
     */
    @GetMapping("/add-form")
    public String addDishPage(Model model) {
        model.addAttribute("dish", new Dish());
        model.addAttribute("actionUrl", "/dishes/add");
        model.addAttribute("bodyContent", "add-edit-dish");
        return "add-edit-dish";
    }

    /**
     * Помошен метод за приказ на формата за едитирање.
     * @param id ID на јадењето што треба да се едитира.
     * @param model Модел за додавање атрибути.
     * @return Име на погледот (add-edit-dish) или редирект ако јадењето не е најдено.
     */
    @GetMapping("/edit-form/{id}")
    public String editDishPage(@PathVariable Long id, Model model) {
        return this.dishService.listDishes().stream().map(dish -> {
            model.addAttribute("dish", dish);
            model.addAttribute("actionUrl", "/dishes/edit/" + id);
            model.addAttribute("bodyContent", "add-edit-dish");
            return "add-edit-dish";
        }).toString();
    }

    @PostMapping("/add") // Одговара на mapping: /dishes/add
    public String saveDish(@RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime) {
        this.dishService.create(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    /**
     * 4.3 Ажурирање јадење
     * @param id ID на јадењето што се ажурира.
     * @param dishId ID на јадењето ( String)
     * @param name Име на јадењето (String)
     * @param cuisine Кујна (String)
     * @param preparationTime Време на подготовка (int)
     * @return Редирект кон /dishes.
     */
    @PostMapping("/edit/{id}") // Одговара на mapping: /dishes/edit/{id}
    public String editDish(@PathVariable Long id,
                           @RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime) {
        this.dishService.update(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    /**
     * 4.4 Бришење јадење
     * @param id ID на јадењето што се брише.
     * @return Редирект кон /dishes.
     */
    @PostMapping("/delete/{id}") // Одговара на mapping: /dishes/delete/{id}
    public String deleteDish(@PathVariable Long id) {
        dishService.delete(id);
        return "redirect:/dishes";
    }
}