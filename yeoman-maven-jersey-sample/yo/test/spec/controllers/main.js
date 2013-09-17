'use strict';

describe('Controller: MainCtrl', function () {

  // load the controller's module
  beforeEach(module('yoApp'));

  var books = [
    {isbn:'11111111', title:'book 1', author:'author 1'},
    {isbn:'22222222', title:'book 2', author:'author 2'},
    {isbn:'33333333', title:'book 3', author:'author 3'}
  ];

  var $httpBackend

  beforeEach(inject(function (_$httpBackend_) {
    $httpBackend = _$httpBackend_;
    $httpBackend.whenGET('./rest/books').respond(books)
  }));

  var MainCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MainCtrl = $controller('MainCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of books to the scope', function () {
    expect(scope.books.length).toBe(0);
    $httpBackend.flush();
    expect(scope.books.length).toBe(3);
  });
});
