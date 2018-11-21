package com.ming.pinyougou.common;

/** 0：未审核   1：已审核   2：审核未通过   3：关闭 //todo
 * @author m969130721@163.com
 * @date 18-10-31 下午4:04
 */

public class SellerStatusEnum {

    private Integer status;

    private String desc;


    SellerStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

}
