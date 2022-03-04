package com.example.bestwebsolutions.controller;

import com.example.bestwebsolutions.model.Photo;
import com.example.bestwebsolutions.services.SnapShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("")
public class SnapShotController {

    @Autowired
    SnapShotService service;

    @GetMapping("/{item}")
    public ModelAndView getObjectsByNameOrType(@PathVariable("item") String item) {
        List<Photo> photos = service.getAll(item.isEmpty() ? "mountain" : item);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showPhotos");
        modelAndView.addObject("photos", photos);
        modelAndView.addObject("type", item);
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView getObjectsByNameOrType() {
        return getObjectsByNameOrType("mountain");
    }

    //@PostMapping(path="/search")
    @RequestMapping(value = "/search", method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"application/x-www-form-urlencoded"})
    public ModelAndView searchObjects(@RequestBody MultiValueMap searchPhoto) {
        return getObjectsByNameOrType(searchPhoto.getFirst("search").toString());
    }
}
