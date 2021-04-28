package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Menu;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
