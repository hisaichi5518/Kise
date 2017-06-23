# 稀勢(Kise)

## Step: Install Kise

```
TBD
```

## Step: Unitをつくる

```java
package com.github.hisaichi5518.kise.example.units;

import android.view.View;

import com.github.hisaichi5518.kise.Unit;

public class ViewVisibleUnit extends Unit<View> {
    @Override
    public void customAction(View view) throws Exception {
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void defaultAction(View view) {
        view.setVisibility(View.GONE);
    }
}
```

## Step: Unitを呼び出して、invoke する

```java
package com.github.hisaichi5518.kise.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.hisaichi5518.kise.example.units.ViewVisibleUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.activity_main__text);
        assert view != null;
        new ViewVisibleUnit().invoke(view);
    }
}
```

## Step: Firebaseの設定を行う

```java
package com.github.hisaichi5518.kise.example;

import android.app.Application;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();

        FirebaseRemoteConfig.getInstance().setConfigSettings(configSettings);
        FirebaseRemoteConfig.getInstance().setDefaults(R.xml.firebase_remote_config_defaults);
    }
}
```

また、 `app/google-services.json` も必要です。詳しくは[Firebaseのドキュメント](https://firebase.google.com/docs/android/setup)を読んでください。

## Step: FirebaseRemoteConfigにて、配信したいキーと値を設定する

![](images/firebase-remote-config.png)

## Step: Finished!!!

Enjoy! :tada::tada:
サンプルコードは[example](example)以下にあります。

## 注意点:boom::boom::boom:

### Firebase Remote Config

- 値を`true` 以外を設定するとすべて `false` として扱われます
- 「変更を公開する」をサブミットしないと変更は反映されません

### Kise

- パラメータキーは作成したUnitクラスの名前と同じでなければ動作しません
- `true` の時は`customAction`を実行し、`false`の時は`defaultAction`を実行します
- `customAction`を実行した時に `Exception` が発生した場合は、 `defaultAction` を実行します
