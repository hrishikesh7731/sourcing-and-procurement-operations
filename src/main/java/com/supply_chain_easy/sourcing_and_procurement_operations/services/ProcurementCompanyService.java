package com.supply_chain_easy.sourcing_and_procurement_operations.services;

import com.supply_chain_easy.sourcing_and_procurement_operations.dtos.ProcurementCompanyRegistrationDto;
import com.supply_chain_easy.sourcing_and_procurement_operations.transformers.CompanyTransformer;
import com.supply_chain_easy.supply_chain_base_operations.models.Employee;
import com.supply_chain_easy.supply_chain_base_operations.models.ProcurementCompany;
import com.supply_chain_easy.supply_chain_base_operations.repositories.ProcurementCompanyRepository;
import com.supply_chain_easy.supply_chain_base_operations.services.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class ProcurementCompanyService {

    private final CompanyTransformer companyTransformer;
    private final ProcurementCompanyRepository procurementCompanyRepository;
    private final CompanyService companyService;

    public ProcurementCompanyService(CompanyTransformer companyTransformer,
                                     ProcurementCompanyRepository procurementCompanyRepository,
                                     CompanyService companyService){
        this.companyTransformer=companyTransformer;
        this.procurementCompanyRepository=procurementCompanyRepository;
        this.companyService=companyService;
    }

    public ProcurementCompany onBoardProcurementCompany(ProcurementCompanyRegistrationDto procurementCompanyRegistrationDto){
        ProcurementCompany procurementCompany= companyTransformer.transformProcurementCompanyDtoToModel(procurementCompanyRegistrationDto);
        procurementCompany=procurementCompanyRepository.save(procurementCompany);

        Employee adminUser=companyService.createAdminUserForCompany(procurementCompany);
        return procurementCompany;

    }
}
