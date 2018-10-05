package com.caretech.servicefocus.mobile.template

import com.caretech.servicefocus.mobile.template.filter.URLFilter
import com.mitchellbosecke.pebble.extension.*
import org.springframework.stereotype.Component

@Component
class TemplateExtensions : AbstractExtension() {

    override fun getFilters(): MutableMap<String, Filter> {
        var mFilter = super.getFilters()

        if (mFilter == null)
            mFilter = mutableMapOf<String, Filter>()

        mFilter.put("app_url", URLFilter())
        return mFilter
    }

}