package com.github.hisaichi5518.kise;

import static com.github.hisaichi5518.kise.Kise.Store.INSTANCE;

public class Kise {
    enum Store {
        INSTANCE;

        Fetcher fetcher = new Fetcher();
    }

    public static void fetch() {
        INSTANCE.fetcher.fetch();
    }

    public static void enableUrgentUpdateFlag() {
        INSTANCE.fetcher.enableUrgentUpdateFlag();
    }

    public void disableUrgentUpdateFlag() {
        INSTANCE.fetcher.disableUrgentUpdateFlag();
    }

    public void setCacheExpiration(long cacheExpiration) {
        INSTANCE.fetcher.setCacheExpiration(cacheExpiration);
    }
}
