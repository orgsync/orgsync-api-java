/*
 * Copyright 2013 OrgSync
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package com.orgsync.api.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.orgsync.api.FormsResource;
import com.orgsync.api.Resources;
import com.orgsync.api.model.forms.Form;
import com.orgsync.api.model.forms.FormSubmission;
import com.typesafe.config.Config;

public class FormsIntegrationTest extends BaseIntegrationTest<FormsResource> {

    private static final List<? extends Config> formConfigs = DbTemplate.getList("form_descriptions");
    private static final List<? extends Config> submissionsConfigs = DbTemplate.getList("form_submissions");

    public FormsIntegrationTest() {
        super(Resources.FORMS);
    }

    @AfterClass
    public static void cleanup() {
        BaseIntegrationTest.cleanup(Resources.FORMS);
    }

    @Test
    public void tesGetForms() throws Exception {
        List<Form> results = getResult(getResource().getForms());

        testContainsIds(results, formConfigs);
    }

    @Test
    public void testGetForm() throws Exception {
        Config config = formConfigs.get(0);
        int formId = config.getInt("id");

        Form result = getResult(getResource().getForm(formId));

        assertEquals(formId, result.getId());
        assertEquals(config.getString("name"), result.getName());
    }

    @Test
    public void testGetOrgForms() throws Exception {
        int orgId = 52;
        Config config = formConfigs.get(0);
        int formId = config.getInt("id");

        List<Form> results = getResult(getResource().getOrgForms(orgId));

        assertEquals(1, results.size());
        Form result = results.get(0);
        assertEquals(formId, result.getId());
        assertEquals(config.getString("name"), result.getName());
    }

    @Test
    public void testGetFormSubmission() throws Exception {
        Config config = submissionsConfigs.get(0);

        FormSubmission result = getResult(getResource().getFormSubmission(config.getInt("id")));

        assertEquals(config.getInt("id"), result.getId());
    }

}
