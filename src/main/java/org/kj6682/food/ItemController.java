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
    public String listAllItems(Model model) {

        List<Item> itemList = repo.findAll();

        if (itemList != null) {
            model.addAttribute("items", itemList);
        }

        return "allitems";
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String listCategoryItems( @PathVariable("category") String category,
                                     Model model) {

        List<Item> itemList = repo.findByCategory(category);

        if (itemList != null) {
            model.addAttribute("items", itemList);
        }

        return "items";
    }
    private void testItem(List<Item> itemList) {
        Item item = new Item();
        item.setName("Rochefort 10");
        item.setQuantity(Integer.valueOf(10));
        item.setCategory("Birra Trappista");
        itemList.add(item);

        item = new Item();
        item.setName("Rochefort 6");
        item.setQuantity(Integer.valueOf(6));
        item.setCategory("Birra Trappista");
        itemList.add(item);

        item = new Item();
        item.setName("Rochefort 8");
        item.setQuantity(Integer.valueOf(8));
        item.setCategory("Birra Trappista");
        itemList.add(item);

    }

    @RequestMapping(value = "/{category}", method = RequestMethod.POST)
    public String addItemToCategory(@PathVariable("category") String category, Item item){

        item.setCategory(category);
        repo.save(item);

        return "redirect:/{category}";
    }

}
