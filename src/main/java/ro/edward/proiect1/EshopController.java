package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EshopController {

    @Autowired
    SecuritySession securitySession;

    @Autowired
    UserRegister userRegister;

    @Autowired
    ProductDAO productDAO;

    @GetMapping("/welcomepage")
    public ModelAndView welcomepage() {

        ModelAndView modelAndView = new ModelAndView("welcomepage");
        return modelAndView;
    }

    @GetMapping("/loginpage")
    public ModelAndView loginpage() {
        ModelAndView modelAndView = new ModelAndView("loginpage");
        return modelAndView;
    }

    @GetMapping("/registerpage")
    public ModelAndView registerpage() {
        ModelAndView modelAndView = new ModelAndView("registerpage");
        return modelAndView;
    }

    @GetMapping("/magazinpage")
    public ModelAndView showAll() {
        if (!securitySession.isUserLogged()) {
            return new ModelAndView("redirect:/loginpage");

        }
        ModelAndView modelAndView = new ModelAndView("magazinpage");
        modelAndView.addObject("logged", securitySession.isUserLogged());
        List<Product> productList = productDAO.findAll();
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @GetMapping("/stocamplificatoarepage")
    public ModelAndView stocamplificatoarepage() {
        ModelAndView modelAndView = new ModelAndView("stocamplificatoarepage");
        return modelAndView;
    }

    @GetMapping("/stoccrossoverepage")
    public ModelAndView stoccrossoverepage() {
        ModelAndView modelAndView = new ModelAndView("stoccrossoverepage");
        return modelAndView;
    }

    @GetMapping("/stocequalizerepage")
    public ModelAndView stocequalizerepage() {
        ModelAndView modelAndView = new ModelAndView("stocequalizerepage");
        return modelAndView;
    }

    @GetMapping("/register")
    public String create(
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("address") String address

    ) {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setAddress(address);

            userRegister.saveUser(user);

        return "redirect:/loginpage";
    }
}