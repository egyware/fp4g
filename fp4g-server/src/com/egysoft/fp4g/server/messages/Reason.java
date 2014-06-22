package com.egysoft.fp4g.server.messages;

public enum Reason {
	Ok, //ok
	Deny, //denegar	
	Banned, //baneado	
	Outdated, //desactualizado
	UserNotFound, //debe registrarse
	IncorrectPassword, //contraseña incorrecta
}
