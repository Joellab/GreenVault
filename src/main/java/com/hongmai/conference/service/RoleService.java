package com.hongmai.conference.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hongmai.conference.model.domain.CpBaseRole;
import com.hongmai.conference.model.domain.Role;
import com.hongmai.conference.model.param.RoleParam;
import com.hongmai.conference.model.vo.RolePageVO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * @author JiaweiWang
 * @date 2021/9/4
 * @description
 */
public interface RoleService extends IService<CpBaseRole> {

}
