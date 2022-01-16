package me.ztiany.mybatis.pojo;

import java.util.List;

/**
 * QueryVO 不是业务类型，而是将常用的多个查询参数封装起来，以方面开发。
 *
 * @author Ztiany
 * Email ztiany3@gmail.com
 * Date 18.5.27 15:38
 */
public class QueryVO {

    private User user;

    private List<Integer> idList;

    private Integer[] idArray;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public Integer[] getIdArray() {
        return idArray;
    }

    public void setIdArray(Integer[] idArray) {
        this.idArray = idArray;
    }

}
