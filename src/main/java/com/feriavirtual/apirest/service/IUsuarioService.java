package com.feriavirtual.apirest.service;

import java.util.List;
import com.feriavirtual.apirest.models.UsuarioJoin;
import com.feriavirtual.apirest.models.Mensaje;
import com.feriavirtual.apirest.models.Usuario;

public interface IUsuarioService {

	Mensaje crearUsuario(Usuario usuario);

	List<UsuarioJoin> listarUsuarios(int idEstado);
	
	Usuario buscarUsuarioPorId(int id);
	
	Mensaje updateUsuario(Usuario usuario, int id);

	Mensaje cambiarEstadoUsuario(int id, int estado);
	
	Usuario verificarUsuario (Usuario usuario);
}
