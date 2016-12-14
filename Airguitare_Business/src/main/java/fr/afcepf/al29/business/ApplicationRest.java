package fr.afcepf.al29.business;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/resources")
public class ApplicationRest extends Application{
@Override
public Set<Class<?>> getClasses() {
	Set<Class<?>> classes = new HashSet<>();
	
	classes.add(BusinessProduit.class);
	return classes;
}
}
