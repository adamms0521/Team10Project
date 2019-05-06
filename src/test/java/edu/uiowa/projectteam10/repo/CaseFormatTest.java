package edu.uiowa.projectteam10.repo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaseFormatTest {

    @Test
    public void convertsCamelCaseToLowerUnderscore() {
        assertThat(CaseFormat.toLowerUnderscore("HomeControllerTest"))
                .isEqualTo("home_controller_test");
    }

}