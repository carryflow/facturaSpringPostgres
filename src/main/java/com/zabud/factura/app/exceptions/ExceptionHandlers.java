package com.zabud.factura.app.exceptions;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zabud.factura.app.shared.shared.dominio.dto.ErrorCode;

@RestControllerAdvice
/*
 * Es un inteceptor que se encarca de controlar las excepciones //que ocurren
 * dentro de la ejecucion de una peticion
 */

/*
 * Existen tres tipos de excepciones: Bases, Tecnicas, Negocio*
 */
public class ExceptionHandlers {
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public ErrorCode handlerException(Exception e) {
//		ErrorCode ec = new ErrorCode();
//		ec.setCodigo(this.getId());
//		ec.setMensaje("ERROR NO CONTROLADO");
//		logError(ec, e);
//		return ec;
//
//	}

	@ExceptionHandler(CantidadItemNoValidaException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode CantidadItemNoValida(CantidadItemNoValidaException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());
		ec.setMensaje("ERROR NO CONTROLADO");
		logError(ec, e);
		return ec;

	}

	/*
	 * Este metodo genera un ID para poder usarlo como referencia en los codigo que
	 * se ven en el Logger
	 */
	public String getId() {
		return UUID.randomUUID().toString();
	}

	@ExceptionHandler(NameNoValidException.class) // Se maneja la excepcion de un tipo especifico, tambien se encarga
	// // de mandar el objeto como respuesta al servidor
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode NameNoValid(NameNoValidException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMensaje(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
										// de la clase Registro
		logError(ec, e);
		return ec;
	}

	@ExceptionHandler(IdNoValidException.class) // Se maneja la excepcion de un tipo especifico, tambien se encarga
	// // de mandar el objeto como respuesta al servidor
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode CodigoNoValido(IdNoValidException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMensaje(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
// de la clase Registro
		logError(ec, e);
		return ec;
	}

	@ExceptionHandler(RegistroNoEncontradoException.class) // Se maneja la excepcion de un tipo especifico, tambien se
	// encarga de mandar el objeto como respuesta al servidor
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode registroNoEncontrado(RegistroNoEncontradoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMensaje(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
// de la clase Registro
		logError(ec, e);
		return ec;
	}

	@ExceptionHandler(ProductoNoEncontradoException.class) // Se maneja la excepcion de un tipo especifico, tambien se
	// encarga de mandar el objeto como respuesta al servidor
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode productoNoEncontrado(ProductoNoEncontradoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMensaje(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
// de la clase Registro
		logError(ec, e);
		return ec;
	}

	@ExceptionHandler(PriceNoValidException.class) // Se maneja la excepcion de un tipo especifico, tambien
	// se encarga de mandar el objeto como respuesta al
	// servidor
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode PrecioIngresadoNoValido(PriceNoValidException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.getId());// El codigo se establece para poder identificar el erro dentro de la
		ec.setMensaje(e.getMessage());// Este mensaje es el que está establecido en el super() dentro del contructor
// de la clase Registro
		logError(ec, e);
		return ec;
	}

	/*
	 * Esta variable es encargada de tomar el nombre de la clase donde sucede la
	 * excepcion
	 */
	private static final Logger LOG = Logger.getLogger(ExceptionHandlers.class.getName());

	/*
	 * Este metodo es encargado de recoger los diferentes mensajes generados por la
	 * excepcion e imprimirlos por la consola
	 */
	private void logError(ErrorCode ec, Exception e) {
		LOG.severe(ec.getCodigo());
		LOG.severe(ec.getMensaje());
		LOG.severe(e.getMessage());
	}

}
