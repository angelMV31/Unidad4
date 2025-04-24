package controllers;

import views.primerView;

	public class primerController {
		
		public primerView view;
		
		public primerController() {
			
			view = new primerView("Login");
		}
				
		public void login(){
			
			view.login();
			
		}
		
		public void register() {
			
			view.registro();
		}
		
	}
