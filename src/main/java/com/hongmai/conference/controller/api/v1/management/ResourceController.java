package com.hongmai.conference.controller.api.v1.management;

import com.hongmai.conference.model.domain.Resource;
import com.hongmai.conference.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/API/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /*
    @GetMapping("/list")
    public List<Resource> getList() {
        return resourceService.list();
    }
    */
}
