package codesquad.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository = UserRepository.getInstance();

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userRepository.getAll());
        return "user/list";
    }

    @PostMapping
    public String create(User user) {
        userRepository.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{userId}")
    public String readProfiles(Model model, @PathVariable String userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (!user.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("user", user.get());
        return "user/profile";
    }

    @GetMapping("/{userId}/form")
    public String updateForm(Model model, @PathVariable String userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (!user.isPresent()) {
            return "redirect:/users";
        }
        model.addAttribute("user", user.get());
        return "user/update_form";
    }

    @PostMapping("/{userId}")
    public String update(@PathVariable String userId, User updateUserInfo) {
        updateUserInfo.setUserId(userId);
        System.out.println(updateUserInfo);
        userRepository.update(updateUserInfo);
        return "redirect:/users";
    }
}
