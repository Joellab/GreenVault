package com.hongmai.clonfer.controller.api.v1.management;

import com.hongmai.clonfer.model.domain.Company;
import com.hongmai.clonfer.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JiaweiWang
 * @date 2021/9/4
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("/API/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/list")
    public List<Company> list() {
        return companyService.list();
    }

}
