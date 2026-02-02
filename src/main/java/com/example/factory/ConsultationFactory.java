package com.example.factory;

import com.example.entity.RV;
import com.example.enums.StatutRV;

public class ConsultationFactory {
       public static RV creerConsultation(RV rv) {
        rv.setStatut(StatutRV.FAIT);
        return rv;
    }
}
