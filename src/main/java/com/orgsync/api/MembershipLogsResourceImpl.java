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
package com.orgsync.api;

import static com.orgsync.api.Util.checkNotNull;

import java.util.List;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.ListenableFuture;
import com.orgsync.api.model.membership_logs.MembershipLogEntry;
import com.orgsync.api.model.membership_logs.MembershipLogEntryRequest;

/**
 * The implementation of the membership log entries
 * 
 * @author steffyj
 * 
 */
/* package */class MembershipLogsResourceImpl extends BaseResource implements MembershipLogsResource {

    /* package */MembershipLogsResourceImpl(final ApiClientImpl client) {
        super(client, "/org_membership_log_entries");
    }

    @Override
    public ListenableFuture<ApiResponse<List<MembershipLogEntry>>> getLogEntries(final MembershipLogEntryRequest request) {
        checkNotNull(request);

        return getResponse(RequestParams.get("/org_membership_log_entries", toParams(request)),
                MembershipLogEntry.LIST_TYPE);
    }

    /**
     * Convert the request into the necessary query params
     * 
     * @param request
     *            the request to convert
     * @return the query params to use
     */
    private FluentStringsMap toParams(final MembershipLogEntryRequest request) {
        FluentStringsMap map = new FluentStringsMap();

        if (request.getOrgId() != MembershipLogEntryRequest.NO_ORG_ID) {
            map.add("org_id", String.valueOf(request.getOrgId()));
        }

        if (request.getAccountId() != MembershipLogEntryRequest.NO_ACCOUNT_ID) {
            map.add("account_id", String.valueOf(request.getAccountId()));
        }

        if (request.getStartDate() != null) {
            map.add("start_date", dateToQueryParam(request.getStartDate()));
        }

        if (request.getEndDate() != null) {
            map.add("end_date", dateToQueryParam(request.getEndDate()));
        }

        return map;
    }
}
