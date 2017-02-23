package org.c4sg.service;

import java.util.List;

import org.c4sg.dto.OrganizationDTO;

public interface OrganizationService {

	public void save(OrganizationDTO organizationDTO);

    public List<OrganizationDTO> findOrganizations();
    
    public OrganizationDTO findById(int id);
    
    public List<OrganizationDTO> findByKeyword(String name);
    
    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO);
    
    public OrganizationDTO updateOrganization(int id, OrganizationDTO organizationDTO);
    
    public void deleteOrganization(int id);
}
