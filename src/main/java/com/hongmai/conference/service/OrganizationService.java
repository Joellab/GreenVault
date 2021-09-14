package com.hongmai.conference.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hongmai.conference.model.domain.CpBaseOrginazation;
import com.hongmai.conference.model.domain.CpConferenceRecord;
import com.hongmai.conference.model.domain.Resource;
import com.hongmai.conference.model.vo.ConferencePageVO;
import com.hongmai.conference.model.vo.ConferenceVO;
import com.hongmai.conference.model.vo.OrginazationPageVO;

/**
 * @author JiaweiWang
 * @date 2021/9/8
 * @description
 */
public interface OrganizationService extends IService<CpBaseOrginazation> {
    /**
     *
     * @param page
     * @return
     */
    IPage<OrginazationPageVO> queryOrganizationPage(Page<CpBaseOrginazation> page);

    /**
     *
     * @param conferenceId
     * @return
     */
    ConferenceVO queryOrganizationDetail(String conferenceId);

}
