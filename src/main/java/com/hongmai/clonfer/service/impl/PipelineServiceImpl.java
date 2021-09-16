package com.hongmai.clonfer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongmai.clonfer.mapper.CpConferencePipelineMapper;
import com.hongmai.clonfer.model.domain.CpConferencePipeline;
import com.hongmai.clonfer.service.PipelineService;
import org.springframework.stereotype.Service;

/**
 * @author JiaweiWang
 * @date 2021/9/13
 * @description
 */
@Service
public class PipelineServiceImpl extends ServiceImpl<CpConferencePipelineMapper, CpConferencePipeline> implements PipelineService {
}
