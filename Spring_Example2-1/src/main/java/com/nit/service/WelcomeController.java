package com.nit.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@ResponseBody
	@RequestMapping(path="/user",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public String userLogin(@RequestBody EmployeeDto edto) {
		return edto.toString();
	}
	
	@ResponseBody
	@GetMapping(path="/mobiles",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Mobiles> mobiles(@RequestBody List<Mobiles> mobilee ) {
		return  mobilee;
	}
	
	@ResponseBody
	@PostMapping(value="/hyd/{email}")
	public String get(@PathVariable(name="email") String emailid) {
		return emailid;
	}
	
	@ResponseBody
	@PostMapping(value="/bang")
	public ResponseEntity<String> filterApply(@RequestParam(name="name",required = false) String name) {
		if(name==null) {
			return  new ResponseEntity<String>("null",HttpStatusCode.valueOf(200));
		}
		else {
			if(name.length()==5) {
				return new ResponseEntity<String>(name+"length exactly equals to 5",HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<String>(name+"not equals to length 5 ",HttpStatus.CONFLICT);
			}
		}
	}
}
