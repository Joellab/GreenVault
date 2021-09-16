package com.hongmai.clonfer.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongmai.clonfer.enums.ConferenceStatusEnum;
import com.hongmai.clonfer.enums.NodeStatusEnum;
import com.hongmai.clonfer.exception.ApiException;
import com.hongmai.clonfer.model.domain.CpBaseOrginazation;
import com.hongmai.clonfer.model.domain.CpConferencePipeline;
import com.hongmai.clonfer.model.domain.CpConferenceRecord;
import com.hongmai.clonfer.model.param.SelectTemplateParam;
import com.hongmai.clonfer.model.param.UserPageParam;
import com.hongmai.clonfer.model.param.conference.ConferenceParam;
import com.hongmai.clonfer.model.param.conference.ConferencePipelineParam;
import com.hongmai.clonfer.model.vo.ConferencePageVO;
import com.hongmai.clonfer.model.vo.ConferencePipelineVO;
import com.hongmai.clonfer.model.vo.ConferenceVO;
import com.hongmai.clonfer.service.ConferenceService;
import com.hongmai.clonfer.mapper.CpConferenceRecordMapper;
import com.hongmai.clonfer.service.OrganizationService;
import com.hongmai.clonfer.service.PipelineService;
import com.hongmai.clonfer.util.DateUtil;
import com.hongmai.clonfer.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JiaweiWang
 * @date 2021/9/4
 * @description
 */
@Service
public class ConferenceServiceImpl extends ServiceImpl<CpConferenceRecordMapper, CpConferenceRecord> implements ConferenceService {

    @Autowired
    OrganizationService organizationService;

    @Autowired
    PipelineService pipelineService;

    @Autowired
    UserUtil userUtil;
    /**
     *
     * @param param
     */
    @Override
    public void createConference(ConferenceParam param) {

        if (lambdaQuery().eq(CpConferenceRecord::getTitle, param.getTitle()).one() != null) {
            throw new ApiException("会议名称已存在");
        }
        CpConferenceRecord cpConferenceRecord = new CpConferenceRecord();
        cpConferenceRecord.setTitle(param.getTitle());
        cpConferenceRecord.setSubTitle(param.getSubTitle());
        cpConferenceRecord.setOrganization(param.getOrganization());
        cpConferenceRecord.setGuarantor(JSON.toJSONString(param.getGuarantor()));
        cpConferenceRecord.setLocation(JSON.toJSONString(param.getLocation()));
        cpConferenceRecord.setStartTime(param.getStartTime());
        cpConferenceRecord.setEndTime(param.getEndTime());
        cpConferenceRecord.setExtSetting(param.getExtSetting());

        cpConferenceRecord.setUuid(UUID.randomUUID().toString());
        cpConferenceRecord.setStatus(ConferenceStatusEnum.INIT.getCode());
        cpConferenceRecord.setVersion(0);
        cpConferenceRecord.setCreator(UserUtil.getCurrentUserName());
        cpConferenceRecord.setOperator(UserUtil.getCurrentUserName());
        cpConferenceRecord.setGmtCreate(DateUtil.getCurrentTime());
        cpConferenceRecord.setGmtModified(DateUtil.getCurrentTime());

        for(ConferencePipelineParam conferencePipelineParam : param.getPipeline()) {
            CpConferencePipeline cpConferencePipeline = new CpConferencePipeline();
            cpConferencePipeline.setUuid(UUID.randomUUID().toString());
            cpConferencePipeline.setCpConferenceRecordUuid(cpConferenceRecord.getUuid());
            cpConferencePipeline.setSequence(conferencePipelineParam.getId());
            cpConferencePipeline.setName(conferencePipelineParam.getName());
            cpConferencePipeline.setAction(JSON.toJSONString(conferencePipelineParam.getAction()));
            cpConferencePipeline.setAppliedPopulation(JSON.toJSONString(conferencePipelineParam.getAppliedPopulation()));
            cpConferencePipeline.setOwner(conferencePipelineParam.getOwner().getUuid());
            cpConferencePipeline.setStatus(NodeStatusEnum.INIT.getCode());
            pipelineService.save(cpConferencePipeline);
        }

        save(cpConferenceRecord);
    }

    /**
     *
     * @param param
     */
    @Override
    public void updateConference(ConferenceParam param) {
        CpConferenceRecord cpConferenceRecord = new CpConferenceRecord();
        cpConferenceRecord.setUuid(param.getUuid());
        cpConferenceRecord.setTitle(param.getTitle());
        cpConferenceRecord.setSubTitle(param.getSubTitle());
        cpConferenceRecord.setOrganization(param.getOrganization());
        cpConferenceRecord.setGuarantor(JSON.toJSONString(param.getGuarantor()));
        cpConferenceRecord.setLocation(JSON.toJSONString(param.getLocation()));
        cpConferenceRecord.setStartTime(param.getStartTime());
        cpConferenceRecord.setEndTime(param.getEndTime());
        cpConferenceRecord.setExtSetting(param.getExtSetting());

        cpConferenceRecord.setOperator(UserUtil.getCurrentUserName());
        cpConferenceRecord.setGmtModified(DateUtil.getCurrentTime());

        updateById(cpConferenceRecord);
    }

    /**
     *
     * @param page
     * @return
     */
    @Override
    public IPage<ConferencePageVO> queryConferencePage(Page<CpConferenceRecord> page) {
        QueryWrapper queryWrapperOrg = new QueryWrapper();
        queryWrapperOrg.eq("organization", userUtil.getCurrentUserDetails().getOrginazationUuid());
        IPage<CpConferenceRecord> pages = baseMapper.selectPage(page, queryWrapperOrg);
        IPage<ConferencePageVO> tranferPages = pages.convert(CpConferenceRecord -> BeanUtil.copyProperties(CpConferenceRecord, ConferencePageVO.class));
        for(ConferencePageVO conferencePageVO : tranferPages.getRecords()) {
            QueryWrapper<CpBaseOrginazation> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uuid", conferencePageVO.getOrganization());
            String organizationName;
            try {
                organizationName = organizationService.getOne(queryWrapper).getName();
            } catch (Exception e) {
                organizationName = "组织不存在";
            }
            conferencePageVO.setOrganization(organizationName);
        }
        return tranferPages;
    }

    /**
     *
     * @param conferenceId
     * @return
     */
    @Override
    public ConferenceVO queryConferenceDetail(String conferenceId) {
        CpConferenceRecord conferenceRecord = baseMapper.selectById(conferenceId);
        QueryWrapper<CpConferencePipeline> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cp_conference_record_uuid", conferenceRecord.getUuid());
        List<CpConferencePipeline> cpConferencePipelines = pipelineService.list(queryWrapper);
        ConferenceVO conferenceVO = ConferenceVO.convertDOToVO(conferenceRecord);
        List<ConferencePipelineVO> conferencePipelineVOS = new ArrayList<>();
        for(CpConferencePipeline cpConferencePipeline : cpConferencePipelines) {
            ConferencePipelineVO conferencePipelineVO = new ConferencePipelineVO();
            conferencePipelineVO.setUuid(cpConferencePipeline.getUuid());
            conferencePipelineVO.setName(cpConferencePipeline.getName());
            conferencePipelineVO.setSequence(cpConferencePipeline.getSequence());
            UserPageParam userPageParam = new UserPageParam();
            userPageParam.setFullname(userUtil.getSpecificUserDetailsByUuid(cpConferencePipeline.getOwner()).getFullname());
            userPageParam.setUuid(cpConferencePipeline.getOwner());
            conferencePipelineVO.setOwner(userPageParam);
            conferencePipelineVO.setAction(JSON.parseObject(cpConferencePipeline.getAction(), SelectTemplateParam.class));
            conferencePipelineVO.setAppliedPopulation(JSON.parseArray(cpConferencePipeline.getAppliedPopulation(), SelectTemplateParam.class));
            conferencePipelineVOS.add(conferencePipelineVO);
        }

        conferenceVO.setPipeline(conferencePipelineVOS);
        return conferenceVO;
    }
}




