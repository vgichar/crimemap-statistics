package mk.edu.ukim.finki.mvr.controller;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import mk.edu.ukim.finki.mvr.service.UserService;
import mk.edu.ukim.finki.mvr.model.User;
import mk.edu.ukim.finki.mvr.model.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @RequestMapping(value = "getSessionUser", method = RequestMethod.GET)
    public @ResponseBody
    User getSessionUser() {
        User u = new User();
        u.setUserId(-1);
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx != null && ctx.getAuthentication() != null) {
            String username = ctx.getAuthentication().getName();
            if (username != null && username != "anonymousUser") {
                u = service.getByName(username);
            }
        }
        return u;
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
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(u.getName(), u.getPassword(), c));
        }
        return u;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public @ResponseBody
    boolean logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return true;
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    User register(@RequestBody User user) {
        return service.register(user);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User getById(@PathVariable int id) {
        return service.getById(id);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "getByName/{name}", method = RequestMethod.GET)
    public @ResponseBody
    User getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "getByEmail/{email}", method = RequestMethod.GET)
    public @ResponseBody
    User getByEmail(@PathVariable String email) {
        return service.getByEmail(email);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody
    boolean update(@RequestBody User user) {
        service.update(user);
        return true;
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    boolean delete(@PathVariable int id) {
        service.delete(id);
        return true;
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "queryAll", method = RequestMethod.GET)
    public @ResponseBody
    List<User> queryAll() {
        return service.queryAll();
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "queryAllUserRoles", method = RequestMethod.GET)
    public @ResponseBody
    List<UserRole> queryAllUsertypes() {
        return service.queryAllUserRoles();
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "queryUsersByUserRole", method = RequestMethod.POST)
    public @ResponseBody
    List<User> queryUsersByUsertype(@RequestBody UserRole usertype) {
        return service.queryUsersByUserRole(usertype);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "queryUsersByPS/{PS}", method = RequestMethod.GET)
    public @ResponseBody
    List<User> queryUsersByPS(@PathVariable String PS) {
        return service.queryUsersByPS(PS);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "queryUsersBySVR/{SVR}", method = RequestMethod.GET)
    public @ResponseBody
    List<User> queryUsersBySVR(@PathVariable String SVR) {
        return service.queryUsersBySVR(SVR);
    }
}
