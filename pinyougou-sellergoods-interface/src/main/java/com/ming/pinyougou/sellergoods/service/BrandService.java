package com.ming.pinyougou.sellergoods.service;

import com.ming.pinyougou.pojo.TbBrand;

import java.util.List;

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


}
