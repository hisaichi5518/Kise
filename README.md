# 稀勢(Kise)

## :speedboat::dash:Quick start

### :one:アプリにFirebase を追加する

- `app/google-servies.json` を配置する
- `FirebaseRemoteConfig.getInstance().setDefaults(...);` の設定を推奨します

詳しくは[Firebaseのドキュメント](https://firebase.google.com/docs/android/setup)を読んでください。

### :two:FirebaseRemoteConfigにて、配信したいキーと値を設定する

![](images/firebase-remote-config.png)

### :three:Unitクラスを作成する

```java
package com.github.hisaichi5518.kise.example.units;

import android.support.annotation.NonNull;
import android.view.View;

import com.github.hisaichi5518.kise.unittype.Unit;

public class ViewVisibleUnit extends Unit {
    private final View view;

    public ViewVisibleUnit(@NonNull View view) {
        this.view = view;
    }

    @Override
    protected void customAction() throws Exception {
        // FirebaseRemoteConfigから返ってきた値が、trueであればこのアクションが実行されます
        this.view.setVisibility(View.VISIBLE);
    }

    @Override
    protected void defaultAction() {
        // FirebaseRemoteConfigから返ってきた値が、falseであればこのアクションが実行されます
        // またcustomActionがExceptionをthrowするとこのアクションが実行されます
        this.view.setVisibility(View.GONE);
    }
}
```

### :four:FirebaseRemoteConfigから値をfetchし、作成したUnitクラスのinvokeメソッドを実行する

```java
package com.github.hisaichi5518.kise.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.hisaichi5518.kise.Kise;
import com.github.hisaichi5518.kise.example.units.HelloTextUnit;
import com.github.hisaichi5518.kise.example.units.ViewVisibleUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Kise.fetch(); // FirebaseRemoteConfigから値をfetchする処理
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.activity_main__text);
        assert view != null;
        new ViewVisibleUnit(view).invoke(); // invoke!
    }
}
```

### :tada:Enjoy!:tada:

すべてのサンプルコードは[example](example)以下にあります。

## :sunglasses:Unit types

Kiseには、以下のUnit typeがあります。

### Unit

値をなにも指定する必要がない標準的なUnitです。

サンプルコードは、 [ViewVisibleUnit](/example/src/main/java/com/github/hisaichi5518/kise/example/units/ViewVisibleUnit.java)クラスです。

### UnitWithReturn

返り値を指定する必要があるUnitです。

サンプルコードは、 [HelloTextUnit](/example/src/main/java/com/github/hisaichi5518/kise/example/units/HelloTextUnit.java)クラスです。

## :key:FirebaseRemoteConfig パラメータキーの指定

KiseのFirebase RemoteConfigパラメータキーのデフォルト値は、Unitのクラス名です。

しかし、以下のように `this.firebaseRemoteConfigKey` を上書きすることでFirebase RemoteConfig パラメータキーの指定を行うことが出来ます。

これは、他のキーと全く同じ条件で機能の出し分けを行いたい場合に有効です。

```java
public class HelloTextUnit extends UnitWithReturn<String> {

    public HelloTextUnit() {
        this.firebaseRemoteConfigKey = "ViewVisibleUnit";
    }

    ...
}
```

サンプルコードは、 [HelloTextUnit](/example/src/main/java/com/github/hisaichi5518/kise/example/units/HelloTextUnit.java)クラスです。

### 注意

- `this.firebaseRemoteConfigKey` は、コンストラクタの中で変更しなければなりません
