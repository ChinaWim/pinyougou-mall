package com.ming.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ming.pinyougou.mapper.TbBrandMapper;
import com.ming.pinyougou.pojo.TbBrand;
import com.ming.pinyougou.pojo.TbBrandExample;
import com.ming.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-10-27 下午2:14
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;


    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(new TbBrandExample());
    }
}
