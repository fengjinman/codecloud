package com.example.demo.entity;

import lombok.Data;

/**
 * Created by fengjinman Administrator on 2018/9/5.
 */
@Data
public class Sku {

    /**
     * 大分类 品牌 商品 属性
     * 后台可以随时添加分类、品牌、商品、属性(添加品牌必须先选择分类，如果没有该分类，可以先创建分类，同理，添加商品必须先
     * 选择品牌 添加属性必须先选择商品)
     * 一个分类对应多个品牌，一个品牌对应多件商品、一件商品对应多个属性
     * 分类表是个基础表除了类别名称和代号id不记录其他
     * 品牌表有id,品牌名称，和分类的标记
     * 商品表要有自己的id 分类标记，品牌标记，自己的名称
     * 商品表中的图片是展示页所呈现的标准图片，属性表中的图片则是详细图片
     * 属性表 要有自己的id,颜色，尺寸，尺寸单位，商品id，图片
     * sku表 要记录五个标记：userid,classid,brandid,spuid,attrid,然后有库存、描述、价格、价格单位
     * 两个逻辑：
     *   第一个逻辑：
     *   发布商品，发布商品定位到sku层级（最低级），四种id在下拉列表中选择时选中
     *   需要填写的只有库存、描述、价格、价格单位、库存地址（可以下拉选择，在用户信息界面添加或修改）
     *   第二个逻辑：
     *   大分类 品牌 商品 属性 从左到右一对多，可以单独添加或修改
     */
    int id;

    String userid;

    String classid;

    String brandid;

    String spuid;

    String attrid;

    String price;

    String unit;

    String describtion;

    String stock_count;

    String stock_address;
}
