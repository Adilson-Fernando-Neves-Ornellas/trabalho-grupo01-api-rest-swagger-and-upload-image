package com.serratec.trabalhogrupo01.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    
    public static String converterDateParaDataHora(Date data){
        return new SimpleDateFormat("dd/MM/YYY HH:mm:ss").format(data);
    }
}
