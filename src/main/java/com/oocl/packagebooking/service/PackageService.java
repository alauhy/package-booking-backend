package com.oocl.packagebooking.service;

import com.oocl.packagebooking.excpetion.NotFoundException;
import com.oocl.packagebooking.excpetion.NotInSeriveException;
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

    @Override
    public Package save(Package pkg) {
        return packageRepository.save(pkg);
    }

    @Override
    public List<Package> findByStatus(int status) {
        return packageRepository.findByStatus(status);
    }

    @Override
    public Package setPackageStatus(int id, Package pkg) {

        pkg.setId(id);

        return packageRepository.save(pkg);
    }

    @Override
    public Package setPackageBookTime(Package pkg) throws Exception {
        Package pkg1 = packageRepository.findByOrderId(pkg.getOrderId());
        System.out.println(pkg1);
        if (pkg1 != null){
            String[] date = pkg.getBookTime().split(" ");
            String[] time = date[1].split(":");
            pkg1.setStatus(pkg.getStatus());
            pkg1.setBookTime(pkg.getBookTime());

           if (Integer.parseInt(time[0]) >= 9 && Integer.parseInt(time[0]) < 18) {
                return packageRepository.save(pkg1);

            } else throw new NotInSeriveException();
        }
        else throw new NotFoundException();

    }
}
