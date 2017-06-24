package com.github.hisaichi5518.kise;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

class Fetcher {

    private long cacheExpiration = 43200L; // 12 hours
    private boolean urgentUpdateFlag;

    void enableUrgentUpdateFlag() {
        this.urgentUpdateFlag = true;
    }

    void disableUrgentUpdateFlag() {
        this.urgentUpdateFlag = false;
    }

    void setCacheExpiration(long cacheExpiration) {
        this.cacheExpiration = cacheExpiration;
    }

    void fetch() {
        FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        config.activateFetched();

        config.fetch(urgentUpdateFlag ? 0 : cacheExpiration);
        disableUrgentUpdateFlag();
    }
}
