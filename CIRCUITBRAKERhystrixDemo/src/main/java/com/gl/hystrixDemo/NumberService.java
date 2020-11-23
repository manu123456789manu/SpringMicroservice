package com.gl.hystrixDemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberService {


    @HystrixCommand(fallbackMethod = "fallbackCall")
    public String deriveStringWithNumber()  {
        int num = new Random().nextInt(10);
        if(num % 3 ==0){
            return "Our number is divisible by 3 now!!";
        }else{
            throw new RuntimeException("working to get the number you need");
        }
    }

    public String fallbackCall(){
        return "The number is not divisible by!!! Wait for some more time";
    }
    
    @HystrixCommand(fallbackMethod="customfallbacker")
    public String isValid()
    {
    	int num = new Random().nextInt(10);
    	if(num%4==0)
    	{
    		return "Our no is divisible by 4";
    	}
    	else
    	{
    		throw new RuntimeException("The no is not dvisible by 4");
    	}
    }
    
    public String customfallbacker(){
        return "The number is not divisible by 4 check after some time";
    }
    
    
}
