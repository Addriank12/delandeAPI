package com.delande;

import java.util.HashSet;
import java.util.Set;

import Controller.AuthController;
import Controller.LibroController;
import Controller.UserInfoController;
import Security.JwtRequestFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class delandeApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(CORSFilter.class); // Registra el filtro CORS
        resources.add(JwtRequestFilter.class);
        resources.add(AuthController.class);
        resources.add(LibroController.class);
        resources.add(UserInfoController.class);
        return resources;
    }

}
