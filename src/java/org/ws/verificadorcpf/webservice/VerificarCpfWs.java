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
        int digitosCpf[] = new int[11];
        int i, j, totalSoma, resultado, verificador1, verificador2;
        
        // Efetua a conversao do CPF, de string para digitos numericos
        for (i = 0; i < 11; i++) {
            digitosCpf[i] = cpf.charAt(i) - 48;
        }
        
        // Calcula o primeiro digito verificador
        totalSoma = 0;
        for (i =0, j = 10; i < 9; i++, j--) {
            totalSoma += (digitosCpf[i] * j);
        }
        resultado = totalSoma % 11;
        if ((resultado == 0) || (resultado == 1)) {
            verificador1 = 0;            
        }
        else {
            verificador1 = 11 - resultado;
        }
        
        // Calcula o segundo digito verificador
        totalSoma = 0;
        for (i =0, j = 11; i < 9; i++, j--) {
            totalSoma += (digitosCpf[i] * j);
        }
        totalSoma += (verificador1 * 2);
        resultado = totalSoma % 11;
        if ((resultado == 0) || (resultado == 1)) {
            verificador2 = 0;            
        }
        else {
            verificador2 = 11 - resultado;
        }
        
        // Verifica se o CPF e valido
        if ((verificador1 == digitosCpf[9]) &&
            (verificador2 == digitosCpf[10])) {
            return true;
        }
        return false;
    }
}
