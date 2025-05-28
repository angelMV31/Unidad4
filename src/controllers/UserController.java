package controllers;

import java.util.ArrayList;

import models.User;
import models.UserModel;
import views.UserView;

public class UserController {

	public UserView view;
	
	public UserController() {
		view = new UserView();
	}
	
	public void usuarios() {
		UserModel user = new UserModel();
		ArrayList<User> users = user.get();
		view.mostrarUsuarios(users);
	}
	
	public void update(User userToUpdate)
	{
		view.actualizar(userToUpdate);
	}
	
	public void delete(int user_id)
	{
		view.eliminar(user_id);
	}
}
