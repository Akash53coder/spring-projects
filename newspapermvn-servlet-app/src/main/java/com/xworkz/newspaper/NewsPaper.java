package com.xworkz.newspaper;

import org.springframework.stereotype.Component;

@Component
public class NewsPaper {

	public NewsPaper(){
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}
}
