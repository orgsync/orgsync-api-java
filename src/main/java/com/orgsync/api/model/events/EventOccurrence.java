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
package com.orgsync.api.model.events;

/**
 * Information about a single occurence of an event. The {@link #getStartsAt()} and {@link #getEndsAt()} responses are
 * both {@link String}s, since the return can be either in a full UTC Date string if {@link #isAllDay()} is
 * <code>false</code>, but a day String in the form of 'yyyy-MM-dd' if it {@link #isAllDay()}.
 * 
 * @author steffyj
 * 
 */
public class EventOccurrence {

    private String startsAt;
    private String endsAt;
    private boolean isAllDay;

    public final String getStartsAt() {
        return startsAt;
    }

    public final String getEndsAt() {
        return endsAt;
    }

    public final boolean isAllDay() {
        return isAllDay;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endsAt == null) ? 0 : endsAt.hashCode());
        result = prime * result + (isAllDay ? 1231 : 1237);
        result = prime * result + ((startsAt == null) ? 0 : startsAt.hashCode());
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
        EventOccurrence other = (EventOccurrence) obj;
        if (endsAt == null) {
            if (other.endsAt != null)
                return false;
        } else if (!endsAt.equals(other.endsAt))
            return false;
        if (isAllDay != other.isAllDay)
            return false;
        if (startsAt == null) {
            if (other.startsAt != null)
                return false;
        } else if (!startsAt.equals(other.startsAt))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EventOccurrence [startsAt=" + startsAt + ", endsAt=" + endsAt + ", isAllDay=" + isAllDay + "]";
    }

}
