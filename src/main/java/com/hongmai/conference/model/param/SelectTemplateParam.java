package com.hongmai.conference.model.param;

import com.hongmai.conference.model.param.conference.ConferenceParam;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author JiaweiWang
 * @date 2021/9/13
 * @description
 */
@Data
public class SelectTemplateParam {

    private String title;

    private String code;
}
