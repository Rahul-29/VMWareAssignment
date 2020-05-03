package com.vmware.assignment.controller;

import com.vmware.assignment.error.ApiError;
import com.vmware.assignment.model.MyNumber;
import com.vmware.assignment.model.Output;
import com.vmware.assignment.service.ArithmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ArithmeticController {

        @Autowired
        private ArithmeticService service;

        @PostMapping("/add")
        public ResponseEntity<?> add(@RequestBody MyNumber number){
                try{
                        int x = Integer.parseInt(number.getX());
                        int y = Integer.parseInt(number.getY());
                        Output output = service.performAddition(x, y);
                        return ResponseEntity.ok().body(output);
                }
                catch (Exception e){
                        ApiError apiError = new ApiError(e.getMessage());
                        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
                }
        }

        @PostMapping("/diff")
        public ResponseEntity<?> diff(@RequestBody MyNumber number){
                try{
                        int x = Integer.parseInt(number.getX());
                        int y = Integer.parseInt(number.getY());
                        Output output = service.performSubtraction(x, y);
                        return ResponseEntity.ok().body(output);
                }
                catch (Exception e){
                        ApiError apiError = new ApiError(e.getMessage());
                        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
                }
        }
}
