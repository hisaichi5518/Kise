package com.github.hisaichi5518.kise;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class Unit<ActionParam> implements UnitActions<ActionParam> {
    private long cacheExpiration = 43200L; // 12 hours

    public void invoke(final ActionParam actionParam) {
        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        config.fetch(cacheExpiration)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        config.activateFetched();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Ignore Exception
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (config.getBoolean(key())) {
                            try {
                                customAction(actionParam);
                            } catch (Exception e) {
                                defaultAction(actionParam);
                            }
                        } else {
                            defaultAction(actionParam);
                        }
                    }
                });

        // TODO: Callback methods does not execute if Google play service is out date.
    }

    private String key() {
        return this.getClass().getSimpleName();
    }
}