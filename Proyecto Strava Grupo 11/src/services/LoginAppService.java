package services;

import clases.Usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public Usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		Usuario usuario = new Usuario(email, password);		
		//TODO: Corregir el login
		usuario.setEmail("thomas.e2001@gmail.com");
		usuario.setNombre("Thomas");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		usuario.setContrasenya(sha1);
		
		if (usuario.getEmail().equals(email) && usuario.comprobarContrasenya(password)) {		
			return usuario;
		} else {
			return null;
		}
	}
}