'use strict';

angular.module('yoApp')
  .controller('MainCtrl', function ($scope, $resource) {
    var Book = $resource('./rest/books/:isbn');
    $scope.books = Book.query();
  });
