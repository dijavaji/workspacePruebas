//especifica nuestros mapeos de vistas
var guidebookConfig = function($routeProvider) {
$routeProvider
	.when('/', {
		controller: 'ChaptersController',
		templateUrl: 'view/chapters.html'
	})
	.when('/chapter/:chapterId', {
		controller: 'ChaptersController',
		templateUrl: 'view/chapters.html'
	})
	.when('/addNote/:chapterId', {
		controller: 'AddNoteController',
		templateUrl: 'view/addNote.html'
	})
	.when('/deleteNote/:chapterId/:noteId', {
		controller: 'DeleteNoteController',
		templateUrl: 'view/addNote.html'
	});
};
//define un namespace llamando a un modulo
var app = angular.module('appGuidebook', []).config(guidebookConfig);