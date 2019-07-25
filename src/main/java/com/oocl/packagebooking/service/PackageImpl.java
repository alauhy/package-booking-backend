package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.Package;

import java.util.List;

public interface PackageImpl {
    List<Package> getAll();


    Package save(Package pkg);

    Package setPackageStatus(int id,Package pkg);

}
