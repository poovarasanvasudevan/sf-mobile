{% macro app_header(enablebuttons=true) %}
    <div class="lia-quilt-column lia-quilt-column-24 lia-quilt-column-single lia-quilt-column-atl-navigation-column stuck"
         ng-controller="appbarcontroller">
        <div class="lia-quilt-column-alley lia-quilt-column-alley-single">
            <div class="atl-navigation-wrapper">
                <div class="atl-navigation">
                    <div class="atl-navigation__masthead padding0sm" style="margin-bottom: 0px;">
                        <a class="atl-community-logo" href="{{ '/' | app_url }}"
                           data-ga-category="Utility Navigation Interactions"
                           data-ga-action="Atlassian Community Logo">
                            {% include 'component/icon' %}
                        </a>
                    </div>
                    <a href="{{ '/help' | app_url }}" class="adg-button--subtle white-color-text"> <i
                                class="zmdi zmdi-help"></i> &nbsp;&nbsp;Need a help</a> &nbsp;&nbsp;
                    {% if enablebuttons %}
                        <a class="adg-button--cta-yellow adg-u-small-inline-block" id="atlcommNavLink-register"> Sign
                            up </a>
                        <a id="login-btn" href="{{ '/login' | app_url }}" class="adg-button--subtle"> Log in</a>
                    {% endif %}
                </div>
            </div>
        </div>
    </div>
{% endmacro %}


{% macro app_fullheader() %}

    <div class="lia-quilt-column lia-quilt-column-24 lia-quilt-column-single lia-quilt-column-atl-navigation-column stuck"
         ng-controller="appbarcontroller">
        <div class="lia-quilt-column-alley lia-quilt-column-alley-single">
            <div class="atl-navigation-wrapper full-width">
                <div class="atl-navigation">
                    <div class="atl-navigation__masthead padding0sm" style="margin-bottom: 0px;">
                        <a class="atl-community-logo" href="/" data-ga-category="Utility Navigation Interactions"
                           data-ga-action="Atlassian Community Logo">
                            {% include 'component/icon' %}
                        </a>
                    </div>

                    <div class="atl-navigation__actions">
                        <div class="atl-create-dropdown adg-dropdown adg-u-inline-block adg-u-small-gone">
                            <button class="adg-button--primary js-dropdown-trigger" key="newbutton"
                                    ng-click="newLayoutClick($event)">
                                New Layout&nbsp;<i class="zmdi zmdi-plus-circle"></i>
                            </button>
                            <ul class="adg-dropdown__content" key="newbuttondt">
                                <li class="atl-create-dropdown__item"><a
                                            href="/t5/forums/postpage/choose-node/true/interaction-style/qanda?add-tags=confluence-cloud"
                                            data-ga-category="Content Creation"
                                            data-ga-action="Ask a Question Dropdown Button"
                                            data-ga-label="Create Post Step 1"> <img
                                                src="https://tnckb94959.i.lithium.com/html/assets/img/question-answer.png"
                                                width="48">
                                        <div class="atl-create-dropdown__item__description"><h4>Ask a question</h4>
                                            <span class="adg-u-color-n300">Perfect when you want definitive answers on a topic</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="atl-create-dropdown__item"><a
                                            href="/t5/forums/postpage/choose-node/true/interaction-style/forum?add-tags=confluence-cloud"
                                            data-ga-category="Content Creation"
                                            data-ga-action="Start a Discussion Dropdown Button"
                                            data-ga-label="Create Post Step 1"> <img
                                                src="https://tnckb94959.i.lithium.com/html/assets/img/discussion.png"
                                                width="48">
                                        <div class="atl-create-dropdown__item__description"><h4>Start a discussion</h4>
                                            <span
                                                    class="adg-u-color-n300">Great for ongoing dialogue with others in the community</span>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
{% endmacro %}


{% macro app_breadcrump(breadcrump) %}
    <div class="breadcrump123 lia-quilt-column lia-quilt-column-24 lia-quilt-column-single lia-quilt-column-atl-message-view-pre">
        <div class="lia-quilt-column-alley lia-quilt-column-alley-single">
            <div class="atl-breadcrumbs">
                <ul class="lia-list-standard-inline">
                    <li class="atl-breadcrumbs__crumb"><a href="/"><i class="zmdi zmdi-home"></i> &nbsp;Home</a></li>
                    {% for br in breadcrump %}
                        <li class="atl-breadcrumbs__crumb"><a
                                    href="{{ br.get('link').getAsString() }}">{{ br.get('label').getAsString() }}</a>
                        </li>
                    {% endfor %}
                </ul>
            </div>
        </div>
    </div>
{% endmacro %}