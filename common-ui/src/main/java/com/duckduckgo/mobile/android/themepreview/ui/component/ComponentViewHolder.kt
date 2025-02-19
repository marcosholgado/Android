/*
 * Copyright (c) 2021 DuckDuckGo
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

package com.duckduckgo.mobile.android.themepreview.ui.component

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.duckduckgo.mobile.android.R
import com.duckduckgo.mobile.android.ui.view.OutLinedTextInputView
import com.duckduckgo.mobile.android.ui.view.OutlinedTextInput.Action
import com.duckduckgo.mobile.android.ui.view.listitem.OneLineListItem
import com.duckduckgo.mobile.android.ui.view.listitem.TwoLineListItem
import com.google.android.material.snackbar.Snackbar

sealed class ComponentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(component: Component) {
        // Override in subclass if needed.
    }

    class ButtonComponentViewHolder(parent: ViewGroup) :
        ComponentViewHolder(inflate(parent, R.layout.component_buttons))

    class TopAppBarComponentViewHolder(parent: ViewGroup) :
        ComponentViewHolder(inflate(parent, R.layout.component_top_app_bar))

    class SwitchComponentViewHolder(parent: ViewGroup) :
        ComponentViewHolder(inflate(parent, R.layout.component_switch))

    class RadioButtonComponentViewHolder(parent: ViewGroup) :
        ComponentViewHolder(inflate(parent, R.layout.component_radio_button))

    class CheckboxComponentViewHolder(parent: ViewGroup) :
        ComponentViewHolder(inflate(parent, R.layout.component_checkbox))

    class InfoPanelComponentViewHolder(
        parent: ViewGroup
    ) : ComponentViewHolder(inflate(parent, R.layout.component_info_panel))

    class SearchBarComponentViewHolder(
        parent: ViewGroup
    ) : ComponentViewHolder(inflate(parent, R.layout.component_search_bar))

    class MenuItemComponentViewHolder(
        parent: ViewGroup
    ) : ComponentViewHolder(inflate(parent, R.layout.component_menu_item))

    class OneLineListItemComponentViewHolder(
        parent: ViewGroup
    ) : ComponentViewHolder(inflate(parent, R.layout.component_one_line_item)) {
        override fun bind(component: Component) {
            view.findViewById<OneLineListItem>(R.id.oneLineListItem).apply {
                setClickListener { Snackbar.make(view.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<OneLineListItem>(R.id.oneLineListItemWithImage).apply {
                setClickListener { Snackbar.make(view, component.name, Snackbar.LENGTH_SHORT).show() }
                setLeadingIconClickListener { Snackbar.make(view, "Leading Icon clicked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<OneLineListItem>(R.id.oneLineListItemWithTrailingIcon).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setTrailingIconClickListener { Snackbar.make(view, "Overflow menu clicked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<OneLineListItem>(R.id.oneLineListItemWithLeadingAndTrailingIcons).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setLeadingIconClickListener { Snackbar.make(view, "Leading Icon clicked", Snackbar.LENGTH_SHORT).show() }
                setTrailingIconClickListener { Snackbar.make(view, "Overflow menu clicked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<OneLineListItem>(R.id.oneLineListItemSwitch).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setLeadingIconClickListener { Snackbar.make(view, "Leading Icon clicked", Snackbar.LENGTH_SHORT).show() }
                setOnCheckedChangeListener { view, isChecked -> Snackbar.make(view, "Switch checked: $isChecked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<OneLineListItem>(R.id.oneLineListSwitchItemWithLeadingIcon).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setLeadingIconClickListener { Snackbar.make(view, "Leading Icon clicked", Snackbar.LENGTH_SHORT).show() }
                setOnCheckedChangeListener { view, isChecked -> Snackbar.make(view, "Switch checked: $isChecked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<OneLineListItem>(R.id.oneLineListItemDisabled).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                isEnabled = false
            }

            view.findViewById<OneLineListItem>(R.id.oneLineListItemCustomTextColor).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
            }

        }
    }

    class TwoLineItemComponentViewHolder(
        parent: ViewGroup
    ) : ComponentViewHolder(inflate(parent, R.layout.component_two_line_item)) {
        override fun bind(component: Component) {
            view.findViewById<TwoLineListItem>(R.id.twoLineListItemWithoutImage).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineListItemWithImage).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setLeadingIconClickListener { Snackbar.make(view, "Leading Icon clicked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineListItemWithImageAndTrailingIcon).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setLeadingIconClickListener { Snackbar.make(view, "Leading Icon clicked", Snackbar.LENGTH_SHORT).show() }
                setTrailingIconClickListener { Snackbar.make(view, "Overflow menu clicked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineListItemWithTrailingIcon).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setTrailingIconClickListener { Snackbar.make(view, "Overflow menu clicked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineListItemWithBetaPill).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setTrailingIconClickListener { Snackbar.make(view, "Overflow menu clicked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineSwitchListItem).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setOnCheckedChangeListener { view, isChecked -> Snackbar.make(view, "Switch checked: $isChecked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineSwitchListItemWithImage).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setLeadingIconClickListener { Snackbar.make(view, "Leading Icon clicked", Snackbar.LENGTH_SHORT).show() }
                setOnCheckedChangeListener { view, isChecked -> Snackbar.make(view, "Switch checked: $isChecked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineSwitchListItemWithPill).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                setOnCheckedChangeListener { view, isChecked -> Snackbar.make(view, "Switch checked: $isChecked", Snackbar.LENGTH_SHORT).show() }
            }

            view.findViewById<TwoLineListItem>(R.id.twoLineSwitchListItemWithDisabledSwitch).apply {
                setClickListener { Snackbar.make(this.rootView, component.name, Snackbar.LENGTH_SHORT).show() }
                isEnabled = false
            }
        }
    }

    @SuppressLint("ShowToast")
    class SnackbarComponentViewHolder(parent: ViewGroup) :
        ComponentViewHolder(inflate(parent, R.layout.component_snackbar)) {

        init {
            val container: FrameLayout = view.findViewById(R.id.snackbar_container)
            val snackbarView =
                Snackbar.make(container, "This is a Snackbar message", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Action") {}
                    .view
            (snackbarView.layoutParams as FrameLayout.LayoutParams).gravity = Gravity.CENTER

            container.addView(snackbarView)
        }
    }

    class DividerComponentViewHolder(parent: ViewGroup) : ComponentViewHolder(inflate(parent, R.layout.component_section_divider))

    class OutlinedTextInputComponentViewHolder(val parent: ViewGroup) :
        ComponentViewHolder(inflate(parent, R.layout.component_outline_text_input)) {
        init {
            view.findViewById<OutLinedTextInputView>(R.id.outlinedinputtext1).onAction { toastOnClick(it) }
            view.findViewById<OutLinedTextInputView>(R.id.outlinedinputtext2).onAction { toastOnClick(it) }
            view.findViewById<OutLinedTextInputView>(R.id.outlinedinputtext4).onAction { toastOnClick(it) }
            view.findViewById<OutLinedTextInputView>(R.id.outlinedinputtext6).onAction { toastOnClick(it) }
        }

        private fun toastOnClick(action: Action) = when (action) {
            is Action.PerformEndAction -> Toast.makeText(
                parent.context,
                "End icon clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            viewType: Int
        ): ComponentViewHolder {
            return when (Component.values()[viewType]) {
                Component.BUTTON -> ButtonComponentViewHolder(parent)
                Component.TOP_APP_BAR -> TopAppBarComponentViewHolder(parent)
                Component.SWITCH -> SwitchComponentViewHolder(parent)
                Component.RADIO_BUTTON -> RadioButtonComponentViewHolder(parent)
                Component.CHECKBOX -> CheckboxComponentViewHolder(parent)
                Component.SNACKBAR -> SnackbarComponentViewHolder(parent)
                Component.INFO_PANEL -> InfoPanelComponentViewHolder(parent)
                Component.SEARCH_BAR -> SearchBarComponentViewHolder(parent)
                Component.MENU_ITEM -> MenuItemComponentViewHolder(parent)
                Component.SINGLE_LINE_LIST_ITEM -> OneLineListItemComponentViewHolder(parent)
                Component.TWO_LINE_LIST_ITEM -> TwoLineItemComponentViewHolder(parent)
                Component.SECTION_DIVIDER -> DividerComponentViewHolder(parent)
                Component.OUTLINED_TEXT_INPUT -> OutlinedTextInputComponentViewHolder(parent)
                else -> {
                    TODO()
                }
            }
        }

        private fun inflate(
            parent: ViewGroup,
            layout: Int
        ): View {
            return LayoutInflater.from(parent.context).inflate(layout, parent, false)
        }
    }
}
