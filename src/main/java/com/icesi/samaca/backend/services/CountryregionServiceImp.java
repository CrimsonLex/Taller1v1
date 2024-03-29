package com.icesi.samaca.backend.services;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.samaca.backend.dao.CountryRegionDaoImp;
import com.icesi.samaca.backend.model.person.Countryregion;
import com.icesi.samaca.backend.repositories.CountryregionRepository;

@Service
public class CountryregionServiceImp implements CountryregionService {
	@Autowired
	CountryRegionDaoImp cRDao;
	
	CountryregionRepository cRRepo;

	@Autowired
	public CountryregionServiceImp (CountryregionRepository cRRep) {

		
		cRRepo = cRRep;
		
		
	} 

	@Override
	@Transactional
	public Countryregion saveCr(Countryregion cR) throws IllegalArgumentException {

		//Countryregion result = null;




		if ((cR.getCountryregioncode() != null) && (cR.getName().length()>=5)) {
		
//		boolean cRNotNull = cR.getCountryregioncode().isEmpty();
//		if (!cRNotNull) {
//			

			this.cRDao.save(cR);


		}
		else {

			throw new IllegalArgumentException("Hubo un error en la creacion, revise los datos");
		}



		return cR;


	}

	@Override
	@Transactional
	public Countryregion editCr(Countryregion cR) throws IllegalArgumentException {
		//Countryregion result = null;



		if (cR.getCountryregioncode() != null ) {
			
			Optional<Countryregion> optional = cRRepo.findById(cR.getCountryregionid());

			if(optional.isPresent() &&(cR.getCountryregioncode().length()>=1 && 
					cR.getCountryregioncode().length()<=4) && (cR.getName().length()>=5)) {

				Countryregion toChange = cRRepo.getById(cR.getCountryregionid());

//				toChange.setModifieddate(cR.getModifieddate());
//				toChange.setName(cR.getName());
//				toChange.setStateprovinces(cR.getStateprovinces());
				cRDao.update(cR);

			}
			else {
				
				throw new IllegalArgumentException("Hubo un error en la creacion, revise los datos");
				
			}
		}else {

			throw new IllegalArgumentException("Hubo un error en la creacion, revise los datos");
		}

		return cR;
	}
	
	public Iterable<Countryregion> findAll(){
		return cRDao.findAll();
	}
	
	
	public Optional<Countryregion> findById(Integer id){
		return Optional.of(cRDao.findById(id));
	}

	@Override
	public Countryregion deleteCr(Integer countryregionid) throws IllegalArgumentException {
		Optional<Countryregion> result = cRRepo.findById(countryregionid);
		cRRepo.delete(result.get());
		
		return result.get();
		
	}

}
