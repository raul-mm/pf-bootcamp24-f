package com.bootcamp.ms.microservicebcwallet.infraestructure;

import com.bootcamp.ms.microservicebcwallet.domain.SellerUser;
import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
import com.bootcamp.ms.microservicebcwallet.service.SellerUserBcService;
import com.bootcamp.ms.microservicebcwallet.service.TasasBcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sellerUserBc")
public class SellerUserBcController {
    final Logger logger = LoggerFactory.getLogger(SellerUserBcController.class);

    @Autowired
    private SellerUserBcService sellerUserBcService;

    @GetMapping("/all")
    public Flux<SellerUser> getAll(){

        logger.info("Mostrando la lista de los SellerUser de la bd");
        return sellerUserBcService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<SellerUser> findTasasBC(@PathVariable String id){

        logger.info("Buscando al SellerUser por el id: {}", id);
        return sellerUserBcService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SellerUser> save(@RequestBody SellerUser clientMono){

        logger.info("Registrando al SellerUser en la bd");
        clientMono.setDateReg(LocalDate.now());
        return sellerUserBcService.save(clientMono);
    }

    @PutMapping("/{id}")
    public Mono<SellerUser> edit(@RequestBody SellerUser client, @PathVariable String id){

        logger.info("Editando al SellerUser con el id: {}" ,id);

        return sellerUserBcService.findById(id).flatMap(c -> {
            c = client;

            return sellerUserBcService.save(c);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable String id){
        return sellerUserBcService.findById(id).flatMap(c -> {
            return sellerUserBcService.delete(c);
        });
    }
}
