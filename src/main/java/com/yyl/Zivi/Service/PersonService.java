package com.yyl.Zivi.Service;

import com.yyl.Zivi.Model.Person;

public interface PersonService {
    /**
     * 查询用户是否存在
     * @param loginName 登录名
     * @return 检查结果 0:不存在，9:已存在的用户名 错误:直接返回错误信息
     */
    String checkPerson(String loginName);

    Person findPersonByLoginNameAndPassword(String loginName, String password);
}
