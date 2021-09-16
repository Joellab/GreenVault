package com.hongmai.clonfer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongmai.clonfer.mapper.CompanyMapper;
import com.hongmai.clonfer.model.domain.Company;
import com.hongmai.clonfer.service.CompanyService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * @author JiaweiWang
 * @date 2021/9/4
 * @description
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Override
    public Set<Long> getIdsByUserId(Long userId) {
        return baseMapper.selectIdsByUserId(userId);
    }

    @Override
    public void removeByUserId(Serializable userId) {
        baseMapper.deleteByUserId(userId);
    }

    @Override
    public void insertCompanyByUserId(Long userId, Collection<Long> companyIds) {
        baseMapper.insertCompanyByUserId(userId, companyIds);
    }
}
