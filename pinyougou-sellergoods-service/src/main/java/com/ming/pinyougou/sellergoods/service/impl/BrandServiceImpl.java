package com.ming.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ming.pinyougou.mapper.TbBrandMapper;
import com.ming.pinyougou.entity.PageResult;
import com.ming.pinyougou.entity.Result;
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

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPage(TbBrand tbBrand, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbBrandExample tbBrandExample = new TbBrandExample();
        if (tbBrand != null) {
            TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
            if (tbBrand.getName() != null && tbBrand.getName().length() > 0) {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() > 0) {
                criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
            }
        }

        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(tbBrandExample);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public TbBrand findByOne(Long id) {

        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result add(TbBrand tbBrand) {
        int effect = tbBrandMapper.insertSelective(tbBrand);
        return effect > 0 ? new Result(true, "添加成功")
                : new Result(false, "添加失败");
    }

    @Override
    public Result update(TbBrand tbBrand) {
        int effect = tbBrandMapper.updateByPrimaryKeySelective(tbBrand);
        return effect > 0 ? new Result(true, "更新成功")
                : new Result(false, "更新失败");
    }

    @Override
    public Result delete(Long[] ids) {
        int effect = tbBrandMapper.deleteBatch(ids);
        return effect > 0 ? new Result(true, "删除成功")
                : new Result(false, "删除失败");
    }
}
