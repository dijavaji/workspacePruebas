/** 
 * 
 * 
 * @author dvasquez
 */

/**
 * funcion que permite consumir un restful con jquery y muestra en pantalla
 * direccion prueba restful spring http://rest-service.guides.spring.io/greeting 
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/ResteasyHelloWorld/rest/json/product/get"
    }).then(function(data) {
       $('.greeting-id').append(data.name);
       $('.greeting-content').append(data.qty);
    });
});