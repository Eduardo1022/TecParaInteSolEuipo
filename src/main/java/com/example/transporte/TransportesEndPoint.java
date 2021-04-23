package com.example.transporte;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import me.equipo8.transporte.BorrarCarroRequest;
import me.equipo8.transporte.BorrarCarroResponse;
import me.equipo8.transporte.RegistrarAutoRequest;
import me.equipo8.transporte.RegistrarAutoResponse;

// comentaria 
//otro cometario al azar 
@Endpoint
public class TransportesEndPoint {
    @Autowired
    private Itransportes itransportes;
    @PayloadRoot(namespace = "http://equipo8.me/transporte",  localPart ="RegistrarAutoRequest")
  
    @ResponsePayload
    public RegistrarAutoResponse registrarAutos(@RequestPayload RegistrarAutoRequest peticion){
        RegistrarAutoResponse respuesta = new RegistrarAutoResponse();


        respuesta.setRespuesta( peticion.getPlaca());
        respuesta.setRespuesta("se registro el ::::" +peticion.getMarca());
        respuesta.setRespuesta2(peticion.getAnio());
        respuesta.setRespuesta2(peticion.getAsientos());

        Transportes carro = new Transportes();
        carro.setPlaca(peticion.getPlaca());
        carro.setMarca(peticion.getMarca());
        carro.setAnio(peticion.getAnio());
        carro.setAsientos(peticion.getAsientos());

        itransportes.save(carro);

        return respuesta;
    }

    /////////////////////////////////////////////////borrar

    @PayloadRoot(namespace = "http://equipo8.me/transporte",  localPart ="BorrarCarroRequest")
  
    @ResponsePayload
    public BorrarCarroResponse borraCarro(@RequestPayload BorrarCarroRequest peticion){
        BorrarCarroResponse respuesta = new BorrarCarroResponse();
        respuesta.setRespuesta(" se borro el id: " + peticion.getId());
        //validar qeu no existe
        itransportes.deleteById(peticion.getId());

        return respuesta;
    }
//////////////////////////////////////////////leer


///////////////////////////////////////////////Editar

    
    
}