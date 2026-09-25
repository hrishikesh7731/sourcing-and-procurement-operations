package com.supply_chain_easy.sourcing_and_procurement_operations.services;

import com.supply_chain_easy.sourcing_and_procurement_operations.dtos.ProcurementCompanyRegistrationDto;
import com.supply_chain_easy.sourcing_and_procurement_operations.transformers.CompanyTransformer;
import com.supply_chain_easy.supply_chain_base_operations.models.ProcurementCompany;
import com.supply_chain_easy.supply_chain_base_operations.repositories.ProcurementCompanyRepository;

public class ProcurementCompanyService {

    private final CompanyTransformer companyTransformer;
    private final ProcurementCompanyRepository procurementCompanyRepository;

    public ProcurementCompanyService(CompanyTransformer companyTransformer,ProcurementCompanyRepository procurementCompanyRepository){
        this.companyTransformer=companyTransformer;
        this.procurementCompanyRepository=procurementCompanyRepository;
    }

    public ProcurementCompany onBoardProcurementCompany(ProcurementCompanyRegistrationDto procurementCompanyRegistrationDto){
        ProcurementCompany procurementCompany= companyTransformer.transformProcurementCompanyDtoToModel(procurementCompanyRegistrationDto);
        procurementCompany=procurementCompanyRepository.save(procurementCompany);

        return procurementCompany;

    }
}
