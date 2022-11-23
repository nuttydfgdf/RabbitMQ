package com.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dev.entity.TbOrder;

@Repository
public interface OrderRepository extends JpaRepository<TbOrder, Long>, JpaSpecificationExecutor<TbOrder>{

}
