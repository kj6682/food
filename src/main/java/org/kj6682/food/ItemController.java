package org.kj6682.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by luigi on 19/04/16.
 */
@Controller
@RequestMapping("/")
public class ItemController {

    @Autowired
    private ItemRepository repo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String renderAll(Model model) {

        List<Item> itemList = repo.findAll();

        if (itemList != null) {
            model.addAttribute("items", itemList);
        }

        return "all";
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String renderItems( @PathVariable("category") String category,
                                     Model model) {

        List<Item> itemList = repo.findByCategory(Item.Category.valueOf(category.toUpperCase()));

        if (itemList != null) {
            model.addAttribute("items", itemList);
        }

        return "items";
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.POST)
    public String addItem(@PathVariable("type") String type,
                                    String name,
                                    String quantity,
                                    String category){

        Item item = new Item();
        item.setName(name);
        item.setQuantity(Integer.valueOf(quantity));
        item.setCategory(Item.Category.valueOf(category.toUpperCase()));
        repo.save(item);

        return "redirect:/{type}";
    }

}
