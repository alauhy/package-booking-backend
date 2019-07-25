package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageController {
    @Autowired
    private PackageService packageService;

    @GetMapping("/packages")
    public List<Package> getPackages(){
        return packageService.getAll();
    }
}
