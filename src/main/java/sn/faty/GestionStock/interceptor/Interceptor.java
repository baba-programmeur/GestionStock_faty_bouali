package sn.faty.gestionstock.interceptor;

import org.hibernate.EmptyInterceptor;
import org.jboss.logging.MDC;
import org.springframework.util.StringUtils;


public class Interceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {

        if(StringUtils.hasText(sql) && sql.toLowerCase().startsWith("select")){

            //select utilisateur0.
            //select represente 7 caracteres

            final  String entityName=sql.substring(7,sql.indexOf("."));

            final  String idEntreprise=(String) MDC.get("idEntreprise");

            if (StringUtils.hasLength(entityName) && !entityName.toLowerCase().contains("entreprise") &&
            ! entityName.toLowerCase().contains("roles") && StringUtils.hasLength(idEntreprise))

            if (sql.toLowerCase().contains("where")){

                sql=sql+ "and"+entityName +".idEntreprise="+idEntreprise;

            }else {

                sql=sql+"where"+entityName+".idEntreprise="+idEntreprise;
            }
        }
        return super.onPrepareStatement(sql);
    }


}
