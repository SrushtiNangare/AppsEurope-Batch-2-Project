package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
