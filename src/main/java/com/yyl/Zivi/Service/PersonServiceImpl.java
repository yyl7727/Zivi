package com.yyl.Zivi.Service;

import com.yyl.Zivi.Dao.PersonRepository;
import com.yyl.Zivi.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    /**
     * 查询用户是否存在
     * @param loginName 登录名
     * @return 检查结果 0:不存在，9:已存在的用户名 错误:直接返回错误信息
     */
    @Override
    public String checkPerson(String loginName) {
        try {
            int optionFlag = personRepository.checkPerson(loginName);
            if (optionFlag == 0){
                return "0";
            }else {
                return "9";
            }
        }catch (Exception ex){
            return "意外的错误：" + ex.getMessage();
        }
    }

    /**
     * 通过用户名和密码找到一个用户
     * @param loginName 用户名
     * @param password 密码
     * @return 返回对应用户实体
     */
    @Override
    public Person findPersonByLoginNameAndPassword(String loginName, String password) {
        Person person;
        Optional<Person> optionalPerson = personRepository.findPersonByLoginNameAndPassword(loginName, password);
        person = optionalPerson.orElseGet(Person::new);
        return person;
    }
}
