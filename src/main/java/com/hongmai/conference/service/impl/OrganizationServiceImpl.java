package com.hongmai.conference.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongmai.conference.mapper.CpBaseOrginazationMapper;
import com.hongmai.conference.model.domain.CpBaseOrginazation;
import com.hongmai.conference.model.domain.CpConferenceRecord;
import com.hongmai.conference.model.domain.Resource;
import com.hongmai.conference.model.vo.ConferencePageVO;
import com.hongmai.conference.model.vo.ConferenceVO;
import com.hongmai.conference.model.vo.OrginazationPageVO;
import com.hongmai.conference.service.OrganizationService;
import com.hongmai.conference.service.ResourceService;
import org.springframework.stereotype.Service;

/**
 * @author JiaweiWang
 * @date 2021/9/8
 * @description
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<CpBaseOrginazationMapper, CpBaseOrginazation> implements OrganizationService {

    @Override
    public IPage<OrginazationPageVO> queryOrganizationPage(Page<CpBaseOrginazation> page) {
        IPage<CpBaseOrginazation> pages = baseMapper.selectPage(page, null);
        IPage<OrginazationPageVO> tranferPages = pages.convert(CpBaseOrginazation -> BeanUtil.copyProperties(CpBaseOrginazation, OrginazationPageVO.class));

        return tranferPages;
    }

    @Override
    public ConferenceVO queryOrganizationDetail(String conferenceId) {
        return null;
    }
}
