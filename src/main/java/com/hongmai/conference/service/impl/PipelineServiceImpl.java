package com.hongmai.conference.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongmai.conference.mapper.CpConferencePipelineMapper;
import com.hongmai.conference.model.domain.CpConferencePipeline;
import com.hongmai.conference.service.PipelineService;
import org.springframework.stereotype.Service;

/**
 * @author JiaweiWang
 * @date 2021/9/13
 * @description
 */
@Service
public class PipelineServiceImpl extends ServiceImpl<CpConferencePipelineMapper, CpConferencePipeline> implements PipelineService {
}
