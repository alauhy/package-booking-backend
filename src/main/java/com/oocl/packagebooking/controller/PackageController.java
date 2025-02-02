package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackageController {
    @Autowired
    private PackageService packageService;

    @GetMapping("/packages")
    public List<Package> getPackages(){
        return packageService.getAll();
    }

    @PostMapping("/packages")
    public Package addPackages(@RequestBody Package pkg){
        return packageService.save(pkg);
    }
    @PutMapping("/packages/{id}")
    public Package patchPackages(@PathVariable int id ,@RequestBody Package pkg) throws Exception{
        return packageService.setPackageStatus(id,pkg);
    }
    @GetMapping("/packages/{status}")
    public List<Package> getPackagesByMode(@PathVariable int status){
        return packageService.findByStatus(status);
    }
    @PutMapping("/packages/")
    public Package patchPackages(@RequestBody Package pkg) throws Exception{
        return packageService.setPackageBookTime(pkg);
    }
}
