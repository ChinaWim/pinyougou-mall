package com.ming.pinyougou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-10-28 下午1:45
 */
public class PageResult implements Serializable {

    /**
     * 总记录数
     */
    private long total;

    /**
     * 当前页面结果
     */
    private List rows;

    public PageResult(long total,List rows){
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
