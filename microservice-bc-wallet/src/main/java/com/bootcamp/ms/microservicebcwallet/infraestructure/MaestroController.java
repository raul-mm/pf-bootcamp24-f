package com.bootcamp.ms.microservicebcwallet.infraestructure;

import com.bootcamp.ms.microservicebcwallet.domain.Maestro;
import com.bootcamp.ms.microservicebcwallet.service.MaestroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/redis")
public class MaestroController {

    final Logger logger = LoggerFactory.getLogger(MaestroController.class);

    @Autowired
    private MaestroService maestroService;

    @GetMapping(value = "/{id}")
    public Maestro getUserById(@PathVariable("id") Integer id) {
        return maestroService.getUserForId(id);
    }

    @GetMapping(value = "/sin/{userId}")
    public Maestro getById(@PathVariable("userId") Integer id) {
        logger.info("Getting user with ID {}.", id);
        return maestroService.getUserId(id);
    }

}
