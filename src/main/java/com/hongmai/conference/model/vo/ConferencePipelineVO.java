package com.hongmai.conference.model.vo;

import com.hongmai.conference.model.param.SelectTemplateParam;
import com.hongmai.conference.model.param.UserPageParam;
import com.hongmai.conference.model.param.conference.ConferenceParam;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author JiaweiWang
 * @date 2021/9/13
 * @description
 */
@Data
public class ConferencePipelineVO {

    private String uuid;

    private Integer sequence;

    private String name;

    private SelectTemplateParam action;

    private UserPageParam owner;

    private List<SelectTemplateParam> appliedPopulation;

}
