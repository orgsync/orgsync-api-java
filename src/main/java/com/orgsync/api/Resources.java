package com.orgsync.api;

public final class Resources {

    private Resources() {
        // no create...
    }

    public static final Resource<OrgsResource> ORGS = new Resource<OrgsResource>() {
        @Override
        public OrgsResource get(final ApiClientImpl client) {
            return new OrgsResourceImpl(client);
        }
    };

    public static final Resource<AccountsResource> ACCOUNTS = new Resource<AccountsResource>() {
        @Override
        AccountsResource get(final ApiClientImpl client) {
            return new AccountsResourceImpl(client);
        }
    };

    public static final Resource<CheckbooksResource> CHECKBOOKS = new Resource<CheckbooksResource>() {
        @Override
        CheckbooksResource get(final ApiClientImpl client) {
            return new CheckbooksResourceImpl(client);
        }
    };

    public static final Resource<EventsResource> EVENTS = new Resource<EventsResource>() {
        @Override
        EventsResource get(final ApiClientImpl client) {
            return new EventsResourceImpl(client);
        }
    };

}
