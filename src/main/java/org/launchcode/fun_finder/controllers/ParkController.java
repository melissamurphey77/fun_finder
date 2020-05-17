package org.launchcode.fun_finder.controllers;



import javax.validation.Valid;
import org.launchcode.fun_finder.models.Park;
import org.launchcode.fun_finder.models.ParkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Controller
@RequestMapping("park")
public class ParkController {

    @Autowired
    private ParkDao parkDao;

    // Request path: /park
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("parks", parkDao.findAll());
        model.addAttribute("title", "My Parks");
        return "park/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddParkForm(Model model){
        model.addAttribute("title","Add Park");
        model.addAttribute(new Park());
        return "park/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddParkForm(@ModelAttribute @Valid Park newPark, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Park");
            return "park/add";
        }
         parkDao.save(newPark);

        //Redirect to/park
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveParkForm(Model model) {
        model.addAttribute("parks", parkDao.findAll());
        model.addAttribute("title", "Remove Park");
        return "park/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveParkForm(@RequestParam int[] parkIds){
        for(int parkId : parkIds){
            parkDao.delete(parkId);
        }
        return "redirect:";
    }

}
