/*
 * Copyright 2014 OrgSync
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
package com.orgsync.api.model.orgs;

import com.google.gson.reflect.TypeToken;
import com.orgsync.api.model.forms.FormResponse;
import com.orgsync.api.model.groups.Group;

import java.lang.reflect.Type;
import java.util.List;

/**
 * A model with the full details of a single organization.
 *
 * @author steffyj
 */
public class OrgFull extends Org {

    public static final Type TYPE = new TypeToken<OrgFull>() {
    }.getType();

    private List<FormResponse> profileResponses;
    private List<Integer> accountIds;
    private List<Group> groups;

    public List<FormResponse> getProfileResponses() {
        return profileResponses;
    }

    public List<Integer> getAccountIds() {
        return accountIds;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgFull)) return false;
        if (!super.equals(o)) return false;

        OrgFull orgFull = (OrgFull) o;

        if (!accountIds.equals(orgFull.accountIds)) return false;
        if (!groups.equals(orgFull.groups)) return false;
        if (!profileResponses.equals(orgFull.profileResponses)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + profileResponses.hashCode();
        result = 31 * result + accountIds.hashCode();
        result = 31 * result + groups.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrgFull{");
        sb.append("profileResponses=").append(profileResponses);
        sb.append(", accountIds=").append(accountIds);
        sb.append(", groups=").append(groups);
        sb.append(", super=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
