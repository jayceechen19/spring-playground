package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Paths {

    @GetMapping("/")
    public String helloWord(){
        return "Hello from Spring!";
    }

    @GetMapping("/math/pi")
    public Double mathPi(){
        return 3.141592653589793;
    }
    @GetMapping("/math/calculate")
    public String mathCalculate(
            @RequestParam(value="operation", required=false, defaultValue = "")String operation,
            @RequestParam(value="x",required=true)Integer x,
            @RequestParam(value="y", required=true)Integer y
    )
    {
        Integer result;
        String str;
        if(operation.equals("multiply")){
            result = x*y;
            str = x +" * " +y+" = " +result;

        }else if(operation.equals("divide")){
            result = x/y;
            str = x +" / " +y+" = " +result;
        }else if(operation.equals("subtract")){
            result = x-y;
            str = x +" - " +y+" = " +result;
        }else {
            result = x+y;
            str = x +" + " +y+" = " +result;
        }
        return str;
    }
}
