package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @PostMapping("/math/sum")
    public String mathSum(
            @RequestParam(value = "n", defaultValue = "0") Integer... numbers
    ){
        Integer sum =0;
        String str = "";
        for(Integer num:numbers){
            sum += num;
            str = str.concat(num + " + ");
        }
        str = str.substring(0, str.length() -2);
        str = str.concat("= "+sum);

        return str;
    }
    @RequestMapping("/math/volume/{l}/{w}/{h}")
    public String mathVolume(
            @PathVariable("l") Integer l,
            @PathVariable("w") Integer w,
            @PathVariable("h") Integer h
    ){
        return String.format("The volume of a %d x %d x %d rectange is %d", l, w, h, l*w*h);
    }

    @PostMapping("/math/area")
    public String mathArea(
            @RequestParam Map<String, String> body
    ){
        if(body.get("type").equals("circle")){
            if(body.containsKey("radius")){
                double radius = Double.valueOf(body.get("radius"));
                float result = (float)(Math.PI*Math.pow(radius, 2));
                return String.format("Area of a circle with a radius of %d is %f",(int)radius, result);
            }else{
                return "Invalid";
            }
        }else if(body.get("type").equals("rectangle")){
            if(body.containsKey("length") && body.containsKey("width")){
                int length = Integer.valueOf(body.get("length"));
                int width = Integer.valueOf(body.get("width"));
                int area = length*width;
                return String.format("Area of a %dx%d rectangle is %d", length, width, area);
            }else{
                return "Invalid";
            }
        }else{
            return "Invalid";
        }
    }
}
