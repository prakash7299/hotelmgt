package org.dxctraining.ui;

import java.util.List;

import org.dxctraining.entities.Guest;
import org.dxctraining.exceptions.*;
import org.dxctraining.service.GuestServiceImpl;
import org.dxctraining.service.IGuestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.dxctraining.JavaConfig;

public class GuestMain {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();

	}


}
