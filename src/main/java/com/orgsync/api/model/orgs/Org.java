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
package com.orgsync.api.model.orgs;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.orgsync.api.model.IdAndName;

/**
 * A model for a single organization.
 * 
 * @author steffyj
 * 
 */
public class Org {

    public static final Type TYPE = new TypeToken<Org>() {
    }.getType();

    public static final Type LIST_TYPE = new TypeToken<List<Org>>() {
    }.getType();

    private int id;
    private String shortName;
    private String longName;
    private Date createdAt;
    private IdAndName category;
    private boolean isDisabled;
    private String description;
    private String picUrl;
    private String alternateId;
    private String websiteUrl;
    private int memberCount;
    private Date renewedAt;
    private int umbrellaId;

    public int getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public IdAndName getCategory() {
        return category;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getAlternateId() {
        return alternateId;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public Date getRenewedAt() {
        return renewedAt;
    }

    public int getUmbrellaId() {
        return umbrellaId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alternateId == null) ? 0 : alternateId.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result + (isDisabled ? 1231 : 1237);
        result = prime * result + ((longName == null) ? 0 : longName.hashCode());
        result = prime * result + memberCount;
        result = prime * result + ((picUrl == null) ? 0 : picUrl.hashCode());
        result = prime * result + ((renewedAt == null) ? 0 : renewedAt.hashCode());
        result = prime * result + ((shortName == null) ? 0 : shortName.hashCode());
        result = prime * result + umbrellaId;
        result = prime * result + ((websiteUrl == null) ? 0 : websiteUrl.hashCode());
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
        Org other = (Org) obj;
        if (alternateId == null) {
            if (other.alternateId != null)
                return false;
        } else if (!alternateId.equals(other.alternateId))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (isDisabled != other.isDisabled)
            return false;
        if (longName == null) {
            if (other.longName != null)
                return false;
        } else if (!longName.equals(other.longName))
            return false;
        if (memberCount != other.memberCount)
            return false;
        if (picUrl == null) {
            if (other.picUrl != null)
                return false;
        } else if (!picUrl.equals(other.picUrl))
            return false;
        if (renewedAt == null) {
            if (other.renewedAt != null)
                return false;
        } else if (!renewedAt.equals(other.renewedAt))
            return false;
        if (shortName == null) {
            if (other.shortName != null)
                return false;
        } else if (!shortName.equals(other.shortName))
            return false;
        if (umbrellaId != other.umbrellaId)
            return false;
        if (websiteUrl == null) {
            if (other.websiteUrl != null)
                return false;
        } else if (!websiteUrl.equals(other.websiteUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Org [id=" + id + ", shortName=" + shortName + ", longName=" + longName + ", createdAt=" + createdAt
                + ", category=" + category + ", isDisabled=" + isDisabled + ", description=" + description
                + ", picUrl=" + picUrl + ", alternateId=" + alternateId + ", websiteUrl=" + websiteUrl
                + ", memberCount=" + memberCount + ", renewedAt=" + renewedAt + ", umbrellaId=" + umbrellaId + "]";
    }

}
