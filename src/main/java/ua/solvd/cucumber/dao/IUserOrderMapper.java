package ua.solvd.cucumber.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ua.solvd.cucumber.model.UserOrder;

import java.util.List;

public interface IUserOrderMapper {

    @Select("SELECT order_id AS orderId, user_id AS userId, item_name AS itemName, item_price AS itemPrice " +
            "FROM user_orders WHERE user_id = #{userId}")
    List<UserOrder> getOrdersByUserId(@Param("userId") int userId);
}