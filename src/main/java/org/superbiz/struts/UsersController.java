package org.superbiz.struts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUserForm";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user, Model model) {
        try {
            userService.add(user);
        } catch (Exception | Error e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "addUserForm";
        }

        return "addedUser";
    }
}
