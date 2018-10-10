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
        'contrastDefaultColor': 'light',    // whether, by default, text (contrast)
        // on this palette should be dark or light

        'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
            '200', '300', '400', 'A100'],
        'contrastLightColors': 'light'    // could also specify this if default was 'dark'
    })

    $mdThemingProvider
        .theme('default')
        .primaryPalette('appPallete')
        .accentPalette('appPallete');

})
myApp.directive('textfield', function () {

    return {
        restrict: 'E',
        scope: false,
        replace: true,
        link: function ($scope, element, attributes) {
            $scope.ukey = _.random(999999)
            _.forEach(attributes, function (v, k) {
                $scope[k] = v
            })
        },
        templateUrl: '/template/textfield.html'
    }
})


myApp.controller('indexcontroller', function ($scope) {

})


myApp.controller('appbarcontroller', function ($scope, $mdDialog) {

    function DialogController($scope, $mdDialog) {
        $scope.closeDialog = function () {
            $mdDialog.hide()
        }
    }

    $scope.newLayoutClick = function (ev) {
        $mdDialog.show({
            templateUrl: '/template/newformdialog.html',
            parent: angular.element(document.body),
            clickOutsideToClose: false,
            controller: DialogController
        }).then(function (answer) {

        }, function () {

        })
        //$('#newbuttondt').toggleClass('adg-dropdown__content--active')
    }
})
