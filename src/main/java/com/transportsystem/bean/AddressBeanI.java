package com.transportsystem.bean;

import com.transportsystem.model.Address;

import java.util.List;

public interface AddressBeanI {
 List<Address> getList() throws Exception;

    List<Address> list() throws  Exception;
    void add(Address address) throws Exception;

    void delete(Address address) throws Exception;

    void update(Address address) throws Exception;



}
