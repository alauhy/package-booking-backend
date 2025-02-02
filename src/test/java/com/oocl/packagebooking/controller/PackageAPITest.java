package com.oocl.packagebooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.model.Package;
import com.oocl.packagebooking.service.PackageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PackageController.class)
public class PackageAPITest {
    private static final int NOT_GET = 1;
    private static final int BOOKED = 2;
    private static final int GETED = 3;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private PackageService packageService;

    @Test
    void should_get_all_package() throws Exception{

        Package package1 = new Package();
        package1.setOrderId("201907240001");
        package1.setBookTime(121313454);
        package1.setPhone("13509256210");
        package1.setCustomerName("lxy");
        package1.setStatus(NOT_GET);
        List<Package> packages = new ArrayList<>();
        packages.add(package1);

        when(packageService.getAll()).thenReturn(packages);

        ResultActions resultActions = mvc.perform(get("/packages"))
                .andExpect(jsonPath("$[0].status",is(NOT_GET)))
                .andExpect(jsonPath("$[0].customerName",is("lxy")))
                .andExpect(jsonPath("$[0].phone",is("13509256210")))
                .andExpect(jsonPath("$[0].bookTime",is(121313454)))
                .andExpect(jsonPath("$[0].orderId",is("201907240001")));



    }
    @Test
    void should_save_and_return_package() throws Exception{

        Package package1 = new Package();
        package1.setOrderId("201907240001");
        package1.setBookTime(121313454);
        package1.setPhone("13509256210");
        package1.setCustomerName("lxy");
        package1.setStatus(NOT_GET);

        when(packageService.save(any())).thenReturn(package1);

        ResultActions resultActions = mvc.perform(post("/packages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(package1)))
                .andExpect(jsonPath("$.status",is(NOT_GET)))
                .andExpect(jsonPath("$.customerName",is("lxy")))
                .andExpect(jsonPath("$.phone",is("13509256210")))
                .andExpect(jsonPath("$.bookTime",is(121313454)))
                .andExpect(jsonPath("$.orderId",is("201907240001")));



    }
    @Test
    void should_update_package_status_and_return_package() throws Exception{

        Package package1 = new Package();
        package1.setOrderId("201907240001");
        package1.setBookTime(121313454);
        package1.setPhone("13509256210");
        package1.setCustomerName("lxy");
        package1.setStatus(GETED);

        when(packageService.setPackageStatus(anyInt(),any())).thenReturn(package1);

        ResultActions resultActions = mvc.perform(put("/packages/{id}",package1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(package1)))
                .andExpect(jsonPath("$.status",is(GETED)))
                .andExpect(jsonPath("$.customerName",is("lxy")))
                .andExpect(jsonPath("$.phone",is("13509256210")))
                .andExpect(jsonPath("$.bookTime",is(121313454)))
                .andExpect(jsonPath("$.orderId",is("201907240001")));



    }
    @Test
    void should_return_packages_when_given_status() throws Exception{

        Package package1 = new Package();
        package1.setOrderId("201907240001");
        package1.setBookTime(121313454);
        package1.setPhone("13509256210");
        package1.setCustomerName("lxy");
        package1.setStatus(NOT_GET);
        Package package2 = new Package();
        package2.setOrderId("201907240002");
        package2.setBookTime(121313454);
        package2.setPhone("13509256210");
        package2.setCustomerName("ldd");
        package2.setStatus(NOT_GET);
        Package package3 = new Package();
        package3.setOrderId("201907240001");
        package3.setBookTime(121313454);
        package3.setPhone("13509256210");
        package3.setCustomerName("lxy");
        package3.setStatus(GETED);
        List<Package> packages = new ArrayList<>();
        packages.add(package1);
        packages.add(package2);
        packages.add(package3);
        when(packageService.findByStatus(anyInt())).thenReturn(packages);

        ResultActions resultActions = mvc.perform(get("/packages/{mode}",NOT_GET)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(package1)))
                .andExpect(jsonPath("$[1].status",is(NOT_GET)))
                .andExpect(jsonPath("$[1].customerName",is("ldd")))
                .andExpect(jsonPath("$[1].phone",is("13509256210")))
                .andExpect(jsonPath("$[1].bookTime",is(121313454)))
                .andExpect(jsonPath("$[1].orderId",is("201907240002")));



    }
}
