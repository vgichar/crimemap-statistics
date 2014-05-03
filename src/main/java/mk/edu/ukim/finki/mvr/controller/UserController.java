package mk.edu.ukim.finki.mvr.controller;

import java.util.List;
import mk.edu.ukim.finki.mvr.service.UserService;
import mk.edu.ukim.finki.mvr.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    UserService service;
    
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody List<User> queryAll(){
        return service.queryAll();
    }
    
    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public @ResponseBody User getById(@PathVariable int id) {
        return service.getById(id);
    }
    
    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public @ResponseBody User getByName(@PathVariable String name) {
        return service.getByName(name);
    }
    
    @RequestMapping(value = "email/{email}", method = RequestMethod.GET)
    public @ResponseBody User getByEmail(@PathVariable String email) {
        return service.getByName(email);
    }
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody boolean register(@RequestBody User user) {
        return service.register(user);
    }
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody boolean login(@RequestBody User user) {
        return service.login(user);
    }
    
    @RequestMapping(value = "usertype", method = RequestMethod.POST)
    public @ResponseBody List<User> queryByUsertype(@RequestBody String usertype) {
        return service.queryByUsertype(usertype);
    }
    
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody boolean update(@RequestBody User user) {
        service.update(user);
        return true;
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean delete(@PathVariable int id) {
        service.delete(id);
        return true;
    }
}