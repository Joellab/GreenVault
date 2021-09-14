package com.hongmai.conference.controller.api.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongmai.conference.annotation.Auth;
import com.hongmai.conference.annotation.WebLog;
import com.hongmai.conference.enums.ResultCodeEnum;
import com.hongmai.conference.exception.ApiException;
import com.hongmai.conference.model.domain.CpConferenceRecord;
import com.hongmai.conference.model.param.conference.ConferenceParam;
import com.hongmai.conference.model.vo.ConferencePageVO;
import com.hongmai.conference.model.vo.ConferenceVO;
import com.hongmai.conference.service.ConferenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

/**
 * @author JiaweiWang
 * @date 2021/9/3
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/conference")
@Auth(id = 1000, name = "会议管理")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @PostMapping
    @Auth(id = 1, name = "新增会议")
    @WebLog(description = "新增会议接口")
    public void createConference(@RequestBody @Validated(ConferenceParam.CreateConference.class) ConferenceParam param) {
        conferenceService.createConference(param);
    }


    @DeleteMapping
    @Auth(id = 2, name = "删除会议")
    @WebLog(description = "删除会议接口")
    public String deleteConference(String[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            throw new ApiException(ResultCodeEnum.VALIDATE_FAILED);
        }
        conferenceService.removeByIds(Arrays.asList(ids));
        return ResultCodeEnum.SUCCESS.toString();
    }

    @PutMapping
    @Auth(id = 3, name = "编辑会议")
    @WebLog(description = "编辑会议接口")
    public String updateConference(@RequestBody @Validated(ConferenceParam.UpdateConference.class) ConferenceParam param) {
        conferenceService.updateConference(param);
        return ResultCodeEnum.SUCCESS.toString();
    }

    @GetMapping("/page/{currentPage}")
    @Auth(id = 4, name = "查询会议列表")
    @WebLog(description = "查询会议列表接口")
    public IPage<ConferencePageVO> getConferencePage(@PathVariable("currentPage") int currentPage) {
        Page<CpConferenceRecord> conferencePage = new Page<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setColumn("gmt_create");
        orderItem.setAsc(false);
        conferencePage.setCurrent(currentPage).addOrder(orderItem);
        return conferenceService.queryConferencePage(conferencePage);
    }

    @GetMapping("/detail/{conferenceId}")
    @Auth(id = 5, name = "查询会议详情")
    @WebLog(description = "查询会议详情接口")
    public ConferenceVO getConferenceDetail(@PathVariable("conferenceId") String conferenceId) {
        return conferenceService.queryConferenceDetail(conferenceId);
    }

}
