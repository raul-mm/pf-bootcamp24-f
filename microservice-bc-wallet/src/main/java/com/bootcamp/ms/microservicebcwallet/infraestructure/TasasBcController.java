package com.bootcamp.ms.microservicebcwallet.infraestructure;

import com.bootcamp.ms.microservicebcwallet.domain.TasasBc;
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
@RequestMapping(value = "/tasasBc")
public class TasasBcController {
    final Logger logger = LoggerFactory.getLogger(TasasBcController.class);

    @Autowired
    private TasasBcService tasasBcService;

    @GetMapping("/all")
    public Flux<TasasBc> getAll(){

        logger.info("Mostrando la lista de los TasasBC de la bd");
        return tasasBcService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TasasBc> findTasasBC(@PathVariable String id){

        logger.info("Buscando al cliente por el id: {}", id);
        return tasasBcService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TasasBc> save(@RequestBody TasasBc clientMono){

        logger.info("Registrando al TasasBC en la bd");
        clientMono.setDate(LocalDate.now());
        return tasasBcService.save(clientMono);
    }

    @PutMapping("/{id}")
    public Mono<TasasBc> edit(@RequestBody TasasBc client, @PathVariable String id){

        logger.info("Editando al cliente con el id: {}" ,id);

        return tasasBcService.findById(id).flatMap(c -> {
            c.setTipoCambio(client.getTipoCambio());
            c.setTipo(client.getTipo());
            c.setFlag(client.getFlag());

            return tasasBcService.save(c);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable String id){
        return tasasBcService.findById(id).flatMap(c -> {
            return tasasBcService.delete(c);
        });
    }
}
