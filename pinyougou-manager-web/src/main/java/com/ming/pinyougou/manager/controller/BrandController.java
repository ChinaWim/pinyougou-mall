package com.ming.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ming.pinyougou.entity.PageResult;
import com.ming.pinyougou.entity.Result;
import com.ming.pinyougou.pojo.TbBrand;
import com.ming.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "rows", defaultValue = "1") Integer pageSize) {
        return brandService.findPage(pageNum, pageSize);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            return brandService.add(tbBrand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加异常" + e.getMessage());
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            return brandService.update(tbBrand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新异常:" + e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            return brandService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除异常:" + e.getMessage());
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findByOne(id);
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand, Integer page, Integer rows) {
        return brandService.findPage(tbBrand, page, rows);
    }


    @RequestMapping("/selectOptionList.do")
    public List<Map> selectOptionList() {
        return brandService.selectOptionList();
    }

}
