package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package,Integer> {
    List<Package> findByStatus(int status);

    Package findByOrderId(String orderId);

}
