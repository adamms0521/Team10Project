package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateVanForm;
import edu.uiowa.projectteam10.model.Van;
import edu.uiowa.projectteam10.repository.VanRepository;
import org.springframework.stereotype.Service;

@Service
public class VanServiceImp implements VanService {

    VanRepository vanRepository;

    @Override
    public Van save(Van van) {
        vanRepository.save(van);
        return van;
    }

    @Override
    public Van saveForm(CreateVanForm vanForm) {
        Van newVan = new Van();
        newVan.setRide(vanForm.getRide());
        save(newVan);
        return newVan;
    }
}
