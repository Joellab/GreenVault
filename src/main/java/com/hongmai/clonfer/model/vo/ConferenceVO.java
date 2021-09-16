package com.hongmai.clonfer.model.vo;

import com.hongmai.clonfer.model.domain.CpConferenceRecord;
import lombok.Data;


import java.util.Date;
import java.util.List;

/**
 * @author JiaweiWang
 * @date 2021/9/4
 * @description
 */
@Data
public class ConferenceVO {

    private String uuid;

    private String title;

    private String subTitle;

    private String organization;

    private String guarantor;

    private String location;

    private Date startTime;

    private Date endTime;

    private String status;

    private String creator;

    private List<ConferencePipelineVO> pipeline;

    private Date gmtCreate;

    private Date gmtModified;

    private String extSetting;

    public static ConferenceVO convertDOToVO(CpConferenceRecord cpConferenceRecord) {

        ConferenceVO conferenceVO = new ConferenceVO();
        conferenceVO.setUuid(cpConferenceRecord.getUuid());
        conferenceVO.setTitle(cpConferenceRecord.getTitle());
        conferenceVO.setSubTitle(cpConferenceRecord.getSubTitle());
        conferenceVO.setGuarantor(cpConferenceRecord.getGuarantor());
        conferenceVO.setOrganization(cpConferenceRecord.getOrganization());
        conferenceVO.setLocation(cpConferenceRecord.getLocation());
        conferenceVO.setStatus(cpConferenceRecord.getStatus());
        conferenceVO.setCreator(cpConferenceRecord.getCreator());
        conferenceVO.setStartTime(cpConferenceRecord.getStartTime());
        conferenceVO.setEndTime(cpConferenceRecord.getEndTime());
        conferenceVO.setGmtCreate(cpConferenceRecord.getGmtCreate());
        conferenceVO.setGmtModified(cpConferenceRecord.getGmtModified());
        conferenceVO.setExtSetting(cpConferenceRecord.getExtSetting());

        return conferenceVO;
    }
}
