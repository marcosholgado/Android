/*
 * Copyright (c) 2022 DuckDuckGo
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

package com.duckduckgo.adclick.impl

import com.duckduckgo.adclick.store.AdClickFeatureToggleRepository
import com.duckduckgo.appbuildconfig.api.AppBuildConfig
import com.duckduckgo.di.scopes.AppScope
import com.duckduckgo.feature.toggles.api.FeatureTogglesPlugin
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class AdClickFeatureTogglesPlugin @Inject constructor(
    private val adClickFeatureToggleRepository: AdClickFeatureToggleRepository,
    private val appBuildConfig: AppBuildConfig
) : FeatureTogglesPlugin {
    override fun isEnabled(featureName: String, defaultValue: Boolean): Boolean? {
        val adClickFeature = adClickFeatureValueOf(featureName) ?: return null
        return adClickFeatureToggleRepository.get(adClickFeature, defaultValue) &&
            appBuildConfig.versionCode >= adClickFeatureToggleRepository.getMinSupportedVersion(adClickFeature)
    }
}
