package com.java.zd.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.java.zd.model.GoodEntity;
import com.java.zd.service.GoodService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author djin
 *    Good业务层实现类
 * @date 2020-04-11 16:53:13
 */
@Service(version = "1.0.0")
@Transactional
public class GoodServiceImpl extends BaseServiceImpl<GoodEntity> implements GoodService {
	
}
