package com.example.lab2.Web;

import com.example.lab2.Entities.Customer;
import com.example.lab2.Repositories.Repo;
import groovyjarjarpicocli.CommandLine;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
@SessionAttributes({"id"})
@Controller
@AllArgsConstructor

public class CustomerController {

    @Autowired
    private Repo rr;
    List<Customer> xx;
    @GetMapping(path = "/")
    public String Initialpage(Model model){

        xx = rr.initialpage();
        model.addAttribute("customers", xx);
        model.addAttribute("customer", new Customer());
        return "Main";

    }

    @GetMapping(path = "/Main")
    public String Indexpage(Model model){
        model.addAttribute("customers", xx);
        model.addAttribute("customer", new Customer());
        return "Main";
    }

    @PostMapping(path ="/empInsert")
    public String Addcustomers(Model model, Customer customer, HttpSession session, ModelMap mm) {
        String em;
        String email = (String) session.getAttribute("id");

        if (email == null) {

            xx.add(customer);
            model.addAttribute("customers", xx);
            return "redirect:Main";
        }
        boolean flag = false;
        for(int i = 0; i < xx.size(); ++i) {
            em = xx.get(i).getCemail();
            if (email.equals(em)) {
                xx.remove(i);
                xx.add(customer);
                flag = true;
                break;
            }
        }
        mm.put("id", null);
        session.removeAttribute("id");
       return "redirect:Main";
    }

    @GetMapping (path = "/editCustomer")
    public String EditCustomer(Model model, Customer customer,String id, HttpSession session, ModelMap mm) {
        String em;
        mm.put("id", id);

        for(int i = 0; i < xx.size(); ++i) {
            em = xx.get(i).getCemail();
            if (em.equals(id)) {
                model.addAttribute("customer", xx.get(i));
                break;
            }
        }
        return "Main";
    }

    @GetMapping (path = "/deleteCustomer")
    public String DeleteCustomer(Model model,String id) {
        String em;

        for(int i = 0; i < xx.size(); ++i) {
            em = xx.get(i).getCemail();
            if (em.equals(id)) {
                xx.remove(i);
                break;
            }
        }
        return "redirect:Main";
    }

}
