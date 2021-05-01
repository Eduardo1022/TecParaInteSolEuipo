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
import me.equipo8.transporte.ModificarCarroRequest;
import me.equipo8.transporte.ModificarCarroResponse;
//import me.equipo8.transporte.ListaDeCarrosRequest;
import me.equipo8.transporte.ListaDeCarrosResponse;


@Endpoint
public class TransportesEndPoint {
    @Autowired
    private Itransportes itransportes;


    ///////////////////////////////////agregar/////////////////////
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
//////////////////////////////////////////////listar carros/////////////////////
    @PayloadRoot(namespace = "http://equipo8.me/transporte",  localPart ="ListaDeCarrosRequest")
    @ResponsePayload
    public ListaDeCarrosResponse ListaCarros(){
        ListaDeCarrosResponse respuesta = new ListaDeCarrosResponse();
        Iterable<Transportes> ListaCarros = itransportes.findAll();

        for(Transportes ls : ListaCarros){
            ListaDeCarrosResponse.Lista carros = new ListaDeCarrosResponse.Lista(); 
            
            carros.setId(ls.getId());
            carros.setPlaca(ls.getPlaca());
            carros.setMarca(ls.getMarca());
            carros.setAnio(ls.getAnio());
            carros.setAsientos(ls.getAsientos());
            
            respuesta.getLista().add(carros);
        }
         return respuesta;
    }


///////////////////////////////////////////////Modificar//////////////////

   @PayloadRoot(namespace = "http://equipo8.me/transporte",  localPart ="ModificarCarroRequest")
     @ResponsePayload

    public ModificarCarroResponse modificarCarro(@RequestPayload ModificarCarroRequest peticion){
        ModificarCarroResponse respuesta = new ModificarCarroResponse(); 
        Optional<Transportes> r = itransportes.findById(peticion.getId());
    
        if(r.isPresent()){
            Transportes transportes = new Transportes();
            transportes = r.get();
            transportes.setId(peticion.getId());
            transportes.setMarca(peticion.getMarca());
            transportes.setPlaca(peticion.getPlaca());
            transportes.setAnio(peticion.getAnio());
            transportes.setAsientos(peticion.getAsientos());
            itransportes.save(transportes);
            respuesta.setRespuesta("\n Se modificaron los datos: "+"\n MARCAR: " + peticion.getMarca()+ 
                                                                "\n nPLACA: " +  peticion.getPlaca()+
                                                                "\n AÑO: "+peticion.getAnio()+
                                                                "\n ASIENTO: "+ peticion.getAsientos() );
        }else{
             respuesta.setRespuesta("Id no existe:  " + peticion.getId());
        }
        return respuesta;

            
        
    }
    
    
}


    
    
