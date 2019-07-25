package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService implements PackageImpl {
    @Autowired
    private PackageRepository packageRepository;
    @Override
    public List<Package> getAll() {
        return packageRepository.findAll();
    }
}
