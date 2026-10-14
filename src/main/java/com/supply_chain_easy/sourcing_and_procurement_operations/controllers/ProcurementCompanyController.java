package com.supply_chain_easy.sourcing_and_procurement_operations.controllers;

import com.supply_chain_easy.sourcing_and_procurement_operations.dtos.ProcurementCompanyRegistrationDto;
import com.supply_chain_easy.sourcing_and_procurement_operations.services.EmailService;
import com.supply_chain_easy.sourcing_and_procurement_operations.services.ProcurementCompanyService;
import com.supply_chain_easy.supply_chain_base_operations.models.Employee;
import com.supply_chain_easy.supply_chain_base_operations.enums.ApplicationCode;
import com.supply_chain_easy.supply_chain_base_operations.models.ProcurementCompany;
import com.supply_chain_easy.supply_chain_base_operations.repositories.ProcurementCompanyRepository;
import com.supply_chain_easy.supply_chain_base_operations.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/procurement-company")
public class ProcurementCompanyController {

    private final ProcurementCompanyService procurementCompanyService;
    private final ProcurementCompanyRepository procurementCompanyRepository;
    private final CompanyService companyService;
    private final EmailService emailService;

    @Autowired
    public ProcurementCompanyController(ProcurementCompanyService procurementCompanyService,
                                        ProcurementCompanyRepository procurementCompanyRepository,
                                        CompanyService companyService,EmailService emailService){
        this.procurementCompanyService=procurementCompanyService;
        this.procurementCompanyRepository=procurementCompanyRepository;
        this.companyService=companyService;
        this.emailService=emailService;
    }

    @PostMapping("/on-board")
    public ResponseEntity<ProcurementCompany> onBoardProcurementCompany(@RequestBody ProcurementCompanyRegistrationDto procurementCompanyRegistrationDto){

        ProcurementCompany procurementCompany=procurementCompanyService.onBoardProcurementCompany(procurementCompanyRegistrationDto);
        procurementCompany=procurementCompanyRepository.save(procurementCompany);
        Employee adminEmployee=companyService.createAdminUserForCompany(procurementCompany,ApplicationCode.SPO);
        emailService.sendRegistrationEmailToProcurementCompany(procurementCompany,adminEmployee);

        return new ResponseEntity<>(procurementCompany, HttpStatus.CREATED);
    }
}
