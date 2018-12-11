package com.ming.pinyougou.pojogroup;

import com.ming.pinyougou.pojo.TbGoods;
import com.ming.pinyougou.pojo.TbGoodsDesc;
import com.ming.pinyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-10 下午6:57
 */
public class Goods implements Serializable {

    private TbGoods goods;

    private TbGoodsDesc goodsDesc;

    private List<TbItem> itemList;

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods=" + goods +
                ", goodsDesc=" + goodsDesc +
                ", itemList=" + itemList +
                '}';
    }
}
