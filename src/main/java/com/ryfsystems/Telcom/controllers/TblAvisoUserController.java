package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.TblAvisoUser;
import com.ryfsystems.Telcom.services.ITblAvisoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/aviso")
public class TblAvisoUserController {

    @Autowired
    ITblAvisoUserService tblAvisoUserService;

    @GetMapping("/{cliente}")
    public Map<String, TblAvisoUser> getByClient(@PathVariable(value = "cliente") int cliente) {

        Map<String, TblAvisoUser> response = new HashMap<>();

        Optional<TblAvisoUser> optionalTblAvisoUser = tblAvisoUserService.getAvisoByCliente(cliente);

        if (!optionalTblAvisoUser.isPresent()) {
            return null;
        }

        TblAvisoUser tblAvisoUser = new TblAvisoUser();
        tblAvisoUser.setTipopago(optionalTblAvisoUser.get().getTipopago());

        response.put("aviso", tblAvisoUser);

        return response;
    }
}
