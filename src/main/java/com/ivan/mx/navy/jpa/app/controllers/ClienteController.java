package com.ivan.mx.navy.jpa.app.controllers;


import com.ivan.mx.navy.jpa.app.models.dao.IClienteDao;
import com.ivan.mx.navy.jpa.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    private IClienteDao iClienteDao;

   @RequestMapping(value="/listar",method = RequestMethod.GET)
    public String listarDatos(Model model){
       model.addAttribute("titulo","lista de Clientes");
       model.addAttribute("clientes",iClienteDao.findAll());
       return "listar";
   }
   @RequestMapping(value="/form")
    public String crear(Map<String,Object>model){
       Cliente cliente=new Cliente();
       model.put("titulo","Formulario Cliente");
       model.put("cliente",cliente);
       return"form";
    }
    @RequestMapping(value="/form",method = RequestMethod.POST)
    public String guardar(Cliente cliente){
       iClienteDao.save(cliente);
       return "redirect:listar";
    }

}
