package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Menu;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
    @Query("SELECT m FROM Menu m ORDER BY m.foodPrice ASC")
    List<Menu> getDishesBySortedAmount();

    @Query("SELECT m FROM Menu m Where m.foodName =:foodName")
    List<Menu> getDishesByName();
}