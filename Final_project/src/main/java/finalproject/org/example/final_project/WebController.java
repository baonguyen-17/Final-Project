package finalproject.org.example.final_project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {


    @Autowired
    UserRepo repository;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newSignIn", new SignIn());
        System.out.println();
        return "index";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute SignIn signin, Model model) {
    model.addAttribute("newSignIn", signin);
    repository.save(signin);
    return "index";
    }



}
