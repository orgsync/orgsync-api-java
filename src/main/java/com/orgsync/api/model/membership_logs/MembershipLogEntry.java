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
package com.orgsync.api.model.membership_logs;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import com.google.gson.reflect.TypeToken;

/**
 * A single membership log entry.
 * 
 * @author steffyj
 * 
 */
public class MembershipLogEntry {

    public static final Type TYPE = new TypeToken<MembershipLogEntry>() {
    }.getType();

    public static final Type LIST_TYPE = new TypeToken<List<MembershipLogEntry>>() {
    }.getType();

    private int accountId;
    private String action;
    private Date createdAt;
    private int orgId;

    public final int getAccountId() {
        return accountId;
    }

    public final String getAction() {
        return action;
    }

    public final Date getCreatedAt() {
        return createdAt;
    }

    public final int getOrgId() {
        return orgId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accountId;
        result = prime * result + ((action == null) ? 0 : action.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + orgId;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MembershipLogEntry other = (MembershipLogEntry) obj;
        if (accountId != other.accountId)
            return false;
        if (action == null) {
            if (other.action != null)
                return false;
        } else if (!action.equals(other.action))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (orgId != other.orgId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MembershipLogEntry [accountId=" + accountId + ", action=" + action + ", createdAt=" + createdAt
                + ", orgId=" + orgId + "]";
    }

}
