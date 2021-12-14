package com.medinfotracker.medinfotracker;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;


@SpringBootApplication
public class MedInfoTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedInfoTrackerApplication.class, args);
	}

}
