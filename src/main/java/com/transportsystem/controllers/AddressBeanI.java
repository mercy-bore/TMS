package com.transportsystem.controllers;

import java.util.List;

import com.transportsystem.model.Address;

public interface AddressBeanI {
 List<Address> getList() throws Exception;

    List<Address> list(Address filter) throws  Exception;


}
