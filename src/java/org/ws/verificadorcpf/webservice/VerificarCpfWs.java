/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ws.verificadorcpf.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author anderson
 */
@WebService(serviceName = "VerificarCpfWs")
public class VerificarCpfWs {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "verificarCpf")
    public Boolean verificarCpf(@WebParam(name = "cpf") String cpf) {
        
        return false;
    }
}
