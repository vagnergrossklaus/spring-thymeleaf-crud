package dev.vagnergrossklaus.springthymeleafcrud.controller;

import dev.vagnergrossklaus.springthymeleafcrud.entity.Vehicle;
import dev.vagnergrossklaus.springthymeleafcrud.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping("/vehicle")
    ModelAndView findall(){
        ModelAndView modelAndView = new ModelAndView("/vehicle");
        modelAndView.addObject("vehicles", service.findall());
        return modelAndView;
    }

    @GetMapping("/vehicle/{id}")
    ModelAndView vehicle(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/vehicle");
        modelAndView.addObject("vehicle", service.findById(id));
        return modelAndView;

    }

    @GetMapping("/add")
    ModelAndView add(Vehicle vehicle){
        ModelAndView modelAndView = new ModelAndView("/vehicleedit");
        modelAndView.addObject("vehicle", vehicle);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/vehicleedit");
        modelAndView.addObject("vehicle", service.findById(id));
        return modelAndView;
    }

    @PostMapping("/save")
    ModelAndView save(@Valid Vehicle vehicle, BindingResult result){

        ModelAndView modelAndView;

        if(result.hasErrors()) {
            return add(vehicle);
        }

        try {
            service.save(vehicle);
            modelAndView = findall();
        } catch (Exception ex){
            modelAndView = new ModelAndView("/vehicle");
            modelAndView.addObject(vehicle);
        }

        return modelAndView;

    }

    @GetMapping("/delete/{id}")
    ModelAndView findall(@PathVariable("id") Long id){
        service.deleteById(id);
        return findall();
    }

}
