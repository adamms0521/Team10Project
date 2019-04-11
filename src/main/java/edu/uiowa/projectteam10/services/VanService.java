package edu.uiowa.projectteam10.services;

import edu.uiowa.projectteam10.forms.CreateVanForm;
import edu.uiowa.projectteam10.model.Van;

public interface VanService {
    Van save(Van van);

    Van saveForm(CreateVanForm vanForm);
}
