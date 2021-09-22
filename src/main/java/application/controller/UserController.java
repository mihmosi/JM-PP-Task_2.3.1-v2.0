package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserController {
    private UserService user;

    @Autowired
    public UserController(UserService user) {
        this.user = user;
    }

    @GetMapping(value = "/")
    public String firstPage(ModelMap model){
        List<User> users = user.getAllUsers();
        System.out.println("показать данные" + users.toString());
        model.addAttribute("messages", users);
        return "UsersTablePage";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
        this.user.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User newUser){
        user.addUser(newUser);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/update")
    public String updatePage(@PathVariable("id") int id, ModelMap model){
        System.out.println("показать id "+id);
        User updatingUser = user.read(id);
        model.addAttribute("user", updatingUser);
        return "UpdateUserPage";
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User updatedUser) {
        user.updateUser(updatedUser);
        return "redirect:/";
    }

}