package com.github.hisaichi5518.kise;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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

        config.fetch(urgentUpdateFlag ? 0 : cacheExpiration)
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("KiseFetcher", "onFailure: " + e.getMessage());
                }
            })
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d("KiseFetcher", "onSuccess");
                }
            })
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Log.d("KiseFetcher", "onComplete");
                }
            });
        disableUrgentUpdateFlag();
    }
}
