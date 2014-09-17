package mk.edu.ukim.finki.mvr.controller;

import java.util.LinkedList;
import java.util.List;
import mk.edu.ukim.finki.mvr.model.DropDownList;
import mk.edu.ukim.finki.mvr.model.DropDownListKey;
import mk.edu.ukim.finki.mvr.service.DropDownListKeyService;
import mk.edu.ukim.finki.mvr.service.DropDownListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/DropDownList")
public class DropDownListController {

    @Autowired
    DropDownListService service;
    
    @Autowired
    DropDownListKeyService keyService;

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/getByKeyAndValue/{key}/[value]", method = RequestMethod.GET)
    public @ResponseBody
    DropDownList getByKeyAndValue(@PathVariable String key, @PathVariable String value) {
        return service.getByKeyAndValue(key, value);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    boolean insert(@RequestBody DropDownList entity) {
        return service.insert(entity);
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    boolean update(@RequestBody DropDownList entity) {
        service.update(entity);
        return true;
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/delete/{key}/{value}", method = RequestMethod.DELETE)
    public @ResponseBody
    boolean delete(@PathVariable String key, @PathVariable String value) {
        for(DropDownList ddl : service.getByDependencyKeyAndValue(key, value)){
            service.delete(ddl.getKey(), ddl.getValue());
        }
        service.delete(key, value);
        return true;
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public @ResponseBody
    List<DropDownList> queryAll() {
        return service.queryAll();
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/queryAllKeys", method = RequestMethod.GET)
    public @ResponseBody
    List<DropDownListKey> queryAllKeys() {
        return keyService.queryAll();
    }
    
    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/queryByKey/{key}", method = RequestMethod.GET)
    public @ResponseBody
    List<DropDownList> queryByKey(@PathVariable String key) {
        return service.queryByKey(key);
    }
    
    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/queryByDependency/{dependencyKey}", method = RequestMethod.GET)
    public @ResponseBody
    DropDownListKey queryByDependency(@PathVariable String dependencyKey) {
        return keyService.getByDependency(dependencyKey);
    }
}
