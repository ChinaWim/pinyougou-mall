package com.ming.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ming.pinyougou.pojo.TbBrand;
import com.ming.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-10-27 下午2:21
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

}
