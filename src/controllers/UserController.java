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
}
