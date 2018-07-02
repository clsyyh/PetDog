package org.PetDog.dao;

import org.PetDog.entity.Login;

public interface LoginDao {
    public Login findByLoginnameAndPassword(String loginname, String password);
    public int addLogin(Login login);
    public int updatePwd(Login login);
}
