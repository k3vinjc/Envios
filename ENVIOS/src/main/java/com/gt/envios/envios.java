/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.envios;

import com.gt.svc.envioSvc;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@WebService(serviceName = "envios")
public class envios {

    @Inject
    envioSvc enviosvc;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !"+enviosvc.findAllModel().size();
    }
}
