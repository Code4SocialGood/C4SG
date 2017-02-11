package org.c4sg.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.c4sg.dto.OrganizationDto;
import org.c4sg.entity.Organization;
import org.c4sg.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @CrossOrigin
    @RequestMapping(value = "/api/organization/all", produces = { "application/json" }, method = RequestMethod.GET)
    public List<OrganizationDto> getOrganizations() {
        return organizationService.findOrganizations();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/api/organization/search/byId/{id}", produces = { "application/json" }, method = RequestMethod.GET)
    public OrganizationDto getOrganization(@PathVariable("id") int id) {
        return organizationService.findOrganizations().get(id);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/api/organization/search/byKeyword/{keyWord}", produces = { "application/json" }, method = RequestMethod.GET)
    public List<Object> getOrganization(@PathVariable("keyWord") String keyWord) {
        return organizationService.findByKeyword(keyWord);
    }
    
    @CrossOrigin
    @RequestMapping(value="/api/organization/create", method = RequestMethod.POST)
    public Map<Object, Object> createOrganization(@RequestBody @Valid OrganizationDto organizationDto){
    	System.out.println("**************Create**************");
    	Map<Object, Object> responseData = null;
    	try{
    		OrganizationDto createdOrganization = organizationService.createOrganization(organizationDto);
    		responseData = Collections.synchronizedMap(new HashMap<>());
    		responseData.put("organization", createdOrganization);
    	}catch(Exception e){
    		System.err.println(e);
    	}
    	return responseData;
    }
    
    @CrossOrigin
    @RequestMapping(value="/api/organization/update/{id}", method = RequestMethod.PUT)
    public Map<Object, Object> updateOrganization(@PathVariable("id") int id, @RequestBody @Valid OrganizationDto organizationDto){
    	System.out.println("**************Update : id=" + organizationDto.getId() + "**************");
    	Map<Object, Object> responseData = null;
    	try{
    		OrganizationDto updatedOrganization = organizationService.updateOrganization(id, organizationDto);
    		responseData = Collections.synchronizedMap(new HashMap<>());
    		responseData.put("organization", updatedOrganization);
    	}catch(Exception e){
    		System.err.println(e);
    	}
    	return responseData;
    }
    
    @CrossOrigin
    @RequestMapping(value="/api/organization/delete/{id}", method = RequestMethod.DELETE)
    public void deleteOrganization(@PathVariable("id") int id){
    	System.out.println("************** Delete : id=" + id + "**************");
    	
        try {
            organizationService.deleteOrganization(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

