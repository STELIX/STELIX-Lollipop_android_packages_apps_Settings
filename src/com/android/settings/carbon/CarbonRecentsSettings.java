/*
 * Copyright (C) 2014 CarbonROM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.carbon;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.PreferenceCategory;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.SwitchPreference;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.util.Helpers;

public class CarbonRecentsSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String TAG = "CarbonRecentsSettings";

    private static final String KEY_OMNISWITCH = "omni_switch";
    public static final String OMNISWITCH_PACKAGE_NAME = "org.omnirom.omniswitch";

    private Preference mOmniSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.carbon_recents_settings);
        PackageManager pm = getPackageManager();
        PreferenceScreen prefSet = getPreferenceScreen();
        mOmniSwitch = (Preference)
                prefSet.findPreference(KEY_OMNISWITCH);
        if (!Helpers.isPackageInstalled(OMNISWITCH_PACKAGE_NAME, pm)) {
            prefSet.removePreference(mOmniSwitch);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }
}
