package me.ztiany.mybatis.pojo;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用于演示二级缓存
 */
public class CacheUser implements Serializable {

    private static final long serialVersionUID = 42L;

    private Integer id;//主键 id
    private String username;// 用户姓名
    private String sex;// 性别
    private Date birthday;// 生日
    private String address;// 地址

    private List<Order> orderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "CacheUser [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address + ", ordersList=" + orderList + "]";
    }

}