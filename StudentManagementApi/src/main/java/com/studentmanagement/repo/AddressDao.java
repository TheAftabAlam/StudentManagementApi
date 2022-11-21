package com.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Address;
@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{

}
