package com.poppy.lock;

/**
 * <p>
 * 类说明：商品的服务的接口
 */
public interface GoodsService {

    //获得商品的信息
    GoodsInfo getNum() ;
    //设置商品的数量
    void setNum(int number) ;
}
