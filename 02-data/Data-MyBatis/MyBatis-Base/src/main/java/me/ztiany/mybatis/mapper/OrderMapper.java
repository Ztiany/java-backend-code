package me.ztiany.mybatis.mapper;

import java.util.List;

import me.ztiany.mybatis.pojo.Order;
import me.ztiany.mybatis.pojo.User;

/**
 * @author Ztiany
 * Email ztiany3@gmail.com
 * Date 18.5.27 16:23
 */
public interface OrderMapper {

    /**
     * 查询订单表 order 的所有数据数
     */
    Integer insertOrder(Order order);

    /**
     * 查询订单表 order 的所有数据
     */
    List<Order> selectOrders();

    /**
     * 一对一关联查询，以订单为中心关联用户
     */
    List<Order> selectOrdersList();

    /**
     * 一对多关联
     */
    List<User> selectUserList();

}
