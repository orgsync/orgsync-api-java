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

import static com.orgsync.api.Util.joinList;

import java.util.List;

import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.ListenableFuture;
import com.orgsync.api.model.Success;
import com.orgsync.api.model.accounts.Account;
import com.orgsync.api.model.classifications.Classification;

/*package*/class ClassificationsResourceImpl extends BaseResource implements ClassificationsResource {

    /* package */ClassificationsResourceImpl(final ApiClientImpl client) {
        super(client, "/classifications");
    }

    @Override
    public ListenableFuture<ApiResponse<List<Classification>>> getClassifications() {
        return list(Classification.LIST_TYPE);
    }

    @Override
    public ListenableFuture<ApiResponse<Classification>> getClassification(final int classificationId) {
        return show(classificationId, Classification.TYPE);
    }

    @Override
    public ListenableFuture<ApiResponse<Success>> deleteClassification(final int classificationId) {
        return delete(classificationId, Success.TYPE);
    }

    @Override
    public ListenableFuture<ApiResponse<Classification>> createClassification(final String name) {
        return create(new FluentStringsMap().add("name", name), Classification.TYPE);
    }

    @Override
    public ListenableFuture<ApiResponse<Classification>> updateClassification(final int classificationId,
            final String name) {
        return update(classificationId, new FluentStringsMap().add("name", name), Classification.TYPE);
    }

    @Override
    public ListenableFuture<ApiResponse<List<Account>>> listAccounts(final int classificationId) {
        return getResponse(RequestParams.get(showFor(classificationId) + "/accounts"), Account.LIST_TYPE);
    }

    @Override
    public ListenableFuture<ApiResponse<Success>> addAccountsToClassification(final int classificationId,
            final List<Integer> accountIds) {
        FluentStringsMap params = new FluentStringsMap().add("ids", joinList(accountIds, ","));
        return getResponse(RequestParams.post(showFor(classificationId) + "/accounts/add", params), Success.TYPE);
    }

    @Override
    public ListenableFuture<ApiResponse<Success>> removeAccountsFromClassification(final int classificationId,
            final List<Integer> accountIds) {
        FluentStringsMap params = new FluentStringsMap().add("ids", joinList(accountIds, ","));
        return getResponse(RequestParams.post(showFor(classificationId) + "/accounts/remove", params), Success.TYPE);
    }
}
