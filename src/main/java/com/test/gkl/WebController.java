package com.test.gkl;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("")
public class WebController {


    @RequestMapping ("/")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping("/DebianApplication")
    public String runDebianApplication(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ascii");
       try{
           Process pr = processBuilder.start();
           BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
           StringBuilder outputString = new StringBuilder();
           String line = input.readLine();
           System.out.println(line);
           while(line  != null){
               outputString.append(line+"</br>");
               line = input.readLine();
           }
           System.out.println(outputString);
           return outputString.toString();
       }catch (Exception e){
           return e.getMessage();

       }
    }
}
//jar uf target/deb-test-1.0-SNAPSHOT.jar apt.yml