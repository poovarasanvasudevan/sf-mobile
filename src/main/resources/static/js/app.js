var myApp = angular.module('myApp', ['ngMaterial', 'ngMessages'], function ($interpolateProvider) {
    $interpolateProvider.startSymbol('{#')
    $interpolateProvider.endSymbol('#}')
})

myApp.config(function ($mdThemingProvider) {

    $mdThemingProvider.definePalette('appPallete', {
        '50': '0052CC',
        '100': '0052CC',
        '200': '0052CC',
        '300': '0052CC',
        '400': '0052CC',
        '500': '0052CC',
        '600': '0052CC',
        '700': '0052CC',
        '800': '0052CC',
        '900': '0052CC',
        'A100': '0052CC',
        'A200': '0052CC',
        'A400': '0052CC',
        'A700': '0052CC',
        'contrastDefaultColor': 'dark',    // whether, by default, text (contrast)
                                            // on this palette should be dark or light

        'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
            '200', '300', '400', 'A100'],
        'contrastLightColors': 'dark'    // could also specify this if default was 'dark'
    })

    $mdThemingProvider
        .theme('default')
        .primaryPalette('appPallete')

})

myApp.controller('indexcontroller', function ($scope) {

})

myApp.controller('appbarcontroller', function ($scope, $mdDialog) {

    $scope.newLayoutClick = function (ev) {
        $mdDialog.show({
            templateUrl: '/template/newformdialog.html',
            parent: angular.element(document.body),
            clickOutsideToClose: true
        }).then(function (answer) {

        }, function () {

        })
    }
})
