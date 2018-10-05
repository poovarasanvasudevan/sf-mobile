{% extends "layout/layout" %}
{% block header %}
    {{ app_header(enablebuttons=false) }}
{% endblock %}
{% block body %}
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 padding30">
                        <form class="padding30">
                            <div class="ak-field-group">
                                <label for="username">Username</label>
                                <input
                                        type="text"
                                        class="ak-field-text ak-field__size-medium txt-full-width"
                                        id="username"
                                        name="username"
                                        placeholder="eg. you@yourcompany.com"
                                />
                            </div>
                            <div class="ak-field-group">
                                <label for="password">Password</label>
                                <input
                                        type="password"
                                        class="ak-field-password ak-field__size-medium txt-full-width"
                                        id="password"
                                        name="password"
                                />
                            </div>
                            <div class="ak-field-group">
                                <div class="row">
                                    <div class="ak-field-checkbox col-md-8">
                                        <input type="checkbox" name="option1" id="option1" value="option1"/>
                                        <label for="option1">Keep me logged in</label>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="ak-button ak-button__appearance-primary float-right">Log in</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
{% endblock %}