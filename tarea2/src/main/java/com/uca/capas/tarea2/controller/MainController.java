package com.uca.capas.tarea2.controller;

import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	@RequestMapping("/alumno")
	public @ResponseBody String alumno() {

		Object[] infoAlumno = new Object[]{"Rudi", "Vallecios", "00078217", "Ing. Informatica", "4 anio"};
		return MessageFormat.format("Nombre: {0} <br>Apellido: {1} <br>Carnet: {2} <br>Carrera: {3} <br>Anio cursado: {4}", infoAlumno);
	}
	
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer diaParam = Integer.parseInt(request.getParameter("dia"));
		System.out.println(diaParam);
		Integer mesParam = Integer.parseInt(request.getParameter("mes"));
		System.out.println(mesParam);
		Integer anioParam = Integer.parseInt(request.getParameter("anio"));
		System.out.println(anioParam);
		
		 LocalDate fecha = LocalDate.of(anioParam, mesParam, diaParam); 
		 int diaNumero = DayOfWeek.from(fecha).getValue(); 
		 String diaNombre;
		 
		 switch (diaNumero) {
		 case 1: diaNombre = "Lunes";
		 break;
		 case 2: diaNombre = "Martes";
		 break;
		 case 3: diaNombre = "Miercoles";
		 break;
		 case 4: diaNombre = "Jueves";
		 break;
		 case 5: diaNombre = "Viernes";
		 break;
		 case 6: diaNombre = "Sabado";
		 break;
		 default: diaNombre = "Domingo";
		 break;
		 }
		 
		return "Dia de la semana de " + diaParam + "/" + mesParam + "/" + anioParam + " es: " + diaNombre;
	}
}
