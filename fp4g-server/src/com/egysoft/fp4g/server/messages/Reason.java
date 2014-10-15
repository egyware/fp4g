package com.egysoft.fp4g.server.messages;

public enum Reason {
	AuthOk, //ok	
	Banned, //baneado	
	Outdated, //desactualizado
	UserNotFound, //debe registrarse
	IncorrectPassword, UserLogged, //contraseña incorrecta
}
