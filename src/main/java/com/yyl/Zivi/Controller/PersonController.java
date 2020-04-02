package com.yyl.Zivi.Controller;

import com.yyl.Zivi.Model.Person;
import com.yyl.Zivi.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/Login")
    public String Login(Model model){
        model.addAttribute("person", new Person());
        return "Login";
    }

    @PostMapping("/Login")
    public String loginAction(@Valid Person person, BindingResult bindingResult,
                              HttpSession session, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "数据有误，请重试");
            return "redirect:/Login";
        }
        try {
            String personExistence = personService.checkPerson(person.getLoginName());
            if ("9".equals(personExistence)){
                Person tmpPerson =
                        personService.findPersonByLoginNameAndPassword(person.getLoginName(),person.getPassword());
                //如果账号密码相同保存session，跳转至首页
                if (person.getPassword().equals(tmpPerson.getPassword())){
                    session.setAttribute("Person",tmpPerson);
                    return "redirect:/Index";
                }else {
                    redirectAttributes.addFlashAttribute("error", "密码错误！");
                    return "redirect:/Login";
                }
            }else if ("0".equals(personExistence)){
                redirectAttributes.addFlashAttribute("error", "该用户不存在！");
                return "redirect:/Login";
            }else {
                redirectAttributes.addFlashAttribute("error", "检查用户时出错，请重试。");
                return "redirect:/Login";
            }
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "");
            return "redirect:/Login";
        }
    }

    @GetMapping("/Index")
    public String index(Model model,HttpSession session){
        Person person = (Person) session.getAttribute("Person");
        model.addAttribute("Person",person);
        return "Index";
    }
}
