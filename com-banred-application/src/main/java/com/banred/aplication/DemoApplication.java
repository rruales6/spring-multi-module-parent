package com.banred.aplication;


import com.banred.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//EL PAQUETE A ESCANEAR PARA QUE ENCUENTRE beeans de MYSERVICE
@SpringBootApplication(scanBasePackages = "com.banred.service")
@RestController
//@RequestMapping("api")
public class DemoApplication {

    @Autowired
    private final MyService myService;

    public DemoApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        return myService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}