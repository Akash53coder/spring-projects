package com.xwrokz.newspaper;

import org.springframework.stereotype.Component;

@Component
public class Newspaper {

	Newspaper(){
		System.out.println("bean created"+this.getClass().getSimpleName());
	}
}
