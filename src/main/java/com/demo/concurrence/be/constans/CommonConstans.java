package com.demo.concurrence.be.constans;

public interface CommonConstans {

    String TEXT_JSON 				= "text/json";
    String APPLICATION_JSON 		= "application/json";
    String LIST_NUMBERS             = "listNumbers";
    String OPERATOR                 = "operator";
    String TYPE 					= "type";
    String MESSAGE_TYPE_ERROR 		= "error";
    String MESSAGE 					= "message";
    String MESSAGE_ERROR			= "Ocurrió un error durante la consulta";
    String MESSAGE_TYPE_SUCCESS 	= "success";
    String MESSAGE_SUCCESS			= "Operación exitosa";
    String RESULT                   = "resultado";
    String COMMA                    = ",";
    String OPEN_BRACKET             = "[";
    String CLOSED_BRACKET           = "]";
    String EMPTY                    = "";
    Integer ONE                     = 1;


    static final String REQUEST_ACCUMULATE_NUMBERS_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'> Accumulate Numbers </span></u></h3>"
            + "Método que inicia el proceso de acumulación y calculo. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>listNumbers:</u></b> Lista de Números. </li>"
            + "<li class='list-group-item list-group-item-warning'><b><u>operator:</u></b> Operador. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>listNumbers</b>\" : <em>\"[1,2,3,4,5,6]\"</em>,<br/>"
            +	"    \"<b>operator</b>\" : <em>\"+\"</em><br />"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_ACCUMULATE_NUMBERS_URI = "/accumulatenumbers";


}
