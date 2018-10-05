<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>marko-express</title>

    <meta name="language" content="english">
    <meta http-equiv="content-type" content="text/html">
    <meta name="author" content="Poovarasan Vasudevan">
    <meta name="designer" content="Poovarasan Vasudevan">
    <meta name="publisher" content="Poovarasan Vasudevan">
    <meta name="no-email-collection" content="http://www.unspam.com/noemailcollection/">


    <meta name="description" content="Learn more Poovarasan Vasudevan, his projects, interests and experience.">
    <meta name="keywords" content="Software Engineer,Product Manager,Project Manager,Data Scientist,Computer Scientist">
    <meta name="robots" content="index,follow">
    <meta name="revisit-after" content="7 days">
    <meta name="distribution" content="web">
    <meta name="robots" content="noodp">


    <meta name="distribution" content="web">
    <meta name="web_author" content="Poovarasan Vasudevan">
    <meta name="rating" content="general">
    <meta name="rating" content="safe for kids">
    <meta name="subject" content="Personal">
    <meta name="title" content="Poovarasan Vasudevan - Official Website.">
    <meta name="copyright" content="Copyright 2016">
    <meta name="reply-to" content="poosan9@gmail.com">
    <meta name="abstract"
          content="Poovarasan Vasudevan is an IT strategist, with over 3 years of experience, including software engineering, project management, product development, business operations, and strategy.">
    <meta name="city" content="San Francisco">
    <meta name="country" content="USA">
    <meta name="distribution" content="global">
    <meta name="classification"
          content="Poovarasan Vasudevan is an IT strategist, with over 3 years of experience, including software engineering, project management, product development, business operations, and strategy.">

    <!--Meta Tags for HTML pages on Mobile-->
    <meta name="format-detection" content="telephone=yes"/>
    <meta name="HandheldFriendly" content="true"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!--http-equiv Tags-->
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="Content-Script-Type" content="text/javascript">

    <meta name="theme-color" content="#db5945">
    <link rel="manifest" href="/manifest/manifest.json">

    <link rel="stylesheet" href="{{ request.contextPath }}/css/atlas.css"/>
    <link rel="stylesheet" href="{{ request.contextPath }}/css/angular-material.min.css"/>
    <link rel="stylesheet" href="{{ request.contextPath }}/css/checkbox.css"/>
    <link rel="stylesheet" href="{{ request.contextPath }}/css/flexbox.css"/>
    <link rel="stylesheet" href="{{ request.contextPath }}/css/icons.css"/>
    <link rel="stylesheet" href="{{ request.contextPath }}/css/cssreset.css"/>
    <link rel="stylesheet" href="{{ request.contextPath }}/css/reducedui.css"/>
    <link rel="stylesheet" href="{{ request.contextPath }}/css/app.css"/>

    {% block styles %}{% endblock %}
</head>
{% set CONTEXTPATH = request.contextPath %}
<body ng-app="myApp" ng-controller="indexcontroller">
<noscript>
    Please Enable JavaScript to render
</noscript>
{% import "macro/icons" %}
{% import "macro/utils" %}

<div class="sticky">
    {% block header %}
        {{ app_header() }}
    {% endblock %}
</div>
<div class="content app">
    {% block body %}{% endblock %}
</div>

</body>
<script>
    var CONTEXTPATH = "{{ request.contextPath }}"
</script>


<script src="{{ request.contextPath }}/js/jquery.js"></script>
<script src="{{ request.contextPath }}/js/angular.min.js"></script>
<script src="{{ request.contextPath }}/js/angular-animate.min.js"></script>
<script src="{{ request.contextPath }}/js/angular-aria.min.js"></script>
<script src="{{ request.contextPath }}/js/angular-messages.min.js"></script>
<script src="{{ request.contextPath }}/js/angular-material.min.js"></script>
<script src="{{ request.contextPath }}/js/app.js"></script>
<script src="{{ request.contextPath }}/js/directive.js"></script>
<script>
    if ('serviceWorker' in navigator) {
        navigator.serviceWorker
            .register('/js/sw.js')
            .then(function () {
                console.log("Service Worker Registered")
            })
    }
</script>
{% block scripts %}{% endblock %}
</body>
</html>
