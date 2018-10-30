package com.ming.pinyougou.sellergoods.service;

import com.ming.pinyougou.entity.PageResult;
import com.ming.pinyougou.entity.Result;
import com.ming.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**品牌服务
 * @author m969130721@163.com
 * @date 18-10-27 下午2:02
 */
public interface BrandService {

    /**
     * 返回所有列表
     * @return
     */
     List<TbBrand> findAll();

    /**
     * 分页查找
     * @param pageNum
     * @param pageSize
     * @return
     */
     PageResult findPage(Integer pageNum,Integer pageSize);


     PageResult findPage(TbBrand tbBrand,Integer pageNum,Integer pageSize);

    /**
     * 查找一个
     * @param id
     * @return
     */
     TbBrand findByOne(Long id);

    /**
     * 添加
     * @param tbBrand
     * @return
     */
     Result add(TbBrand tbBrand);

    /**
     * 更新
     * @param tbBrand
     * @return
     */
     Result update(TbBrand tbBrand);


    /**
     * 删除
     * @param ids
     * @return
     */
    Result delete(Long[] ids);


    List<Map> selectOptionList();
}
