package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Menu;
import com.capgemini.exceptions.NoSuchFoodItemException;
import com.capgemini.exceptions.NoSuchOrderException;
import com.capgemini.service.VendorService;

@RestController
@RequestMapping(path = "vendors")
public class VendorController {
 
    @Autowired
    private VendorService adminService;

    // http://localhost:9090/GharKaKhana-api/vendors/findFoodId/   -GET
    @GetMapping(path = "findFoodId/{foodId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> getFoodById(@PathVariable("foodId") int foodId) throws NoSuchOrderException, NoSuchFoodItemException {
        ResponseEntity<Menu> response = null;
        Menu result = adminService.findMenuById(foodId);
        response = new ResponseEntity<Menu>(result, HttpStatus.FOUND);
        return response;
    }
    
    // http://localhost:9090/GharKaKhana-api/vendors/add     -POST
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> addFood(@RequestBody Menu menu) {
        ResponseEntity<Menu> response = null;
        Menu result = adminService.addFood(menu);
        if (result != null)
            response = new ResponseEntity<Menu>(result, HttpStatus.CREATED);
        else
            response = new ResponseEntity<Menu>(result, HttpStatus.BAD_REQUEST);
        return response;
    }

    // http://localhost:9090/GharKaKhana-api/vendors/viewAllOrders    -GET
    @GetMapping(path="/viewAllOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> getAllMenu() {
        ResponseEntity<List<Menu>> response = null;
        List<Menu> result = adminService.viewAllMenu();
        if(result != null)
            response = new ResponseEntity<List<Menu>>(result,HttpStatus.OK);
        else 
            response = new ResponseEntity<List<Menu>>(result,HttpStatus.BAD_REQUEST);
        return response;
    }

    // http://localhost:9090/GharKaKhana-api/vendors/updateFood/
    @PutMapping(path="updateFood/{foodId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity<Menu> modifyFood(@RequestBody Menu menu) throws NoSuchOrderException, NoSuchFoodItemException {
        ResponseEntity<Menu> response = null;
        Menu result = adminService.modifyFood(menu);
        if (result != null)
            response = new ResponseEntity<Menu>(result, HttpStatus.CREATED);
        else
            response = new ResponseEntity<Menu>(result, HttpStatus.BAD_REQUEST);
        return response;
    }

    // http://localhost:9090/GharKaKhana-api/vendors/deleteMenu/    -DELETE
    @DeleteMapping(path = "/deleteMenu/{foodId}")
    public ResponseEntity<Boolean> deleteFood(@PathVariable("foodId") int foodId) throws NoSuchFoodItemException {
        ResponseEntity<Boolean> response = null;
        boolean result = adminService.removeFood(foodId);
        if (result)
            response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
        return response;
    }

}