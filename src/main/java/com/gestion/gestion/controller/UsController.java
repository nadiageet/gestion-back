package com.gestion.gestion.controller;


import com.gestion.gestion.entity.Us;
import com.gestion.gestion.service.UsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsController {

    private UsService usService;

    public UsController(UsService usService) {
        this.usService = usService;
    }

    @PostMapping("/us")
    public Us creatUs(@RequestBody Us us){
        return this.usService.create(us);
    }

    @GetMapping("/us")
    public Page<Us> findAll(Pageable pageable) {
        return  this.usService.findAll(pageable);
    }
}
