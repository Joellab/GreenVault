package com.hongmai.conference.enums;

import com.hongmai.conference.model.vo.AclVO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiaweiWang
 * @date 2021/9/8
 * @description
 */
@Getter
public enum ConstantEnum {

    WEB_BASE_LINK("http://localhost:8081"),

    WEB_RESET_PASSWORD_ROUTE("/reset-password"),

    DEFAULT_AVATAR_URL("https://conf.dev.web.joellab.com/image/avatar_default.png"),

    DEFAULT_ROLE("1"),

    DEFAULT_USER_ACL_ACTION("manage"),

    DEFAULT_USER_ACL_SUBJECT("all"),

    VALID_USER("VALID"),

    INVALID_USER("INVALID");

    private String value;

    ConstantEnum(String value) {
        this.value = value;
    }


}
