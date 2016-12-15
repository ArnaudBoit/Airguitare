package fr.afcepf.al29.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.afcepf.al29.business.BusinessProduit;

@ApplicationPath("/resources")
public class ApplicationRest extends Application{
@Override
public Set<Class<?>> getClasses() {
	Set<Class<?>> classes = new HashSet<>();
	
	classes.add(ServiceProduit.class);
	return classes;
}
}
