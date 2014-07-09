package mk.edu.ukim.finki.mvr.controller;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import mk.edu.ukim.finki.mvr.service.UserService;
import mk.edu.ukim.finki.mvr.model.User;
import mk.edu.ukim.finki.mvr.model.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    SecurityContext securityContext;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    User register(@RequestBody User user) {
        return service.register(user);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    User login(@RequestBody User user) {
        final User u = service.login(user);
        if (u != null) {
            Collection<GrantedAuthority> c = new LinkedList<>();
            c.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return u.getUserRole().getRole();
                }
            });
            securityContext.setAuthentication(new UsernamePasswordAuthenticationToken(u.getName(), u.getPassword(), c));
        }
        return u;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public @ResponseBody
    boolean logout() {
        securityContext.setAuthentication(null);
        return true;
    }

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User getById(@PathVariable int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "getByName/{name}", method = RequestMethod.GET)
    public @ResponseBody
    User getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "getByEmail/{email}", method = RequestMethod.GET)
    public @ResponseBody
    User getByEmail(@PathVariable String email) {
        return service.getByEmail(email);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody
    boolean update(@RequestBody User user) {
        service.update(user);
        return true;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    boolean delete(@PathVariable int id) {
        service.delete(id);
        return true;
    }

    @RequestMapping(value = "queryAll", method = RequestMethod.GET)
    public @ResponseBody
    List<User> queryAll() {
        if (securityContext.getAuthentication() != null) {
            return service.queryAll();
        }
        return null;
    }

    @RequestMapping(value = "queryAllUserRoles", method = RequestMethod.GET)
    public @ResponseBody
    List<UserRole> queryAllUsertypes() {
        return service.queryAllUserRoles();
    }

    @RequestMapping(value = "queryUsersByUserRole", method = RequestMethod.POST)
    public @ResponseBody
    List<User> queryUsersByUsertype(@RequestBody UserRole usertype) {
        return service.queryUsersByUserRole(usertype);
    }
}
